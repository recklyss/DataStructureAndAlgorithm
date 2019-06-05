package DesignPatterns.Singleton;

/**
 * @Author zhangjiaheng
 * @Description 双重锁检测机制实现线程安全单例
 **/
public class DoubleLockSingleton {

    private DoubleLockSingleton() {
    }

    /**
     * 使用volatile屏蔽分配对象时的指令重排序
     */
    private volatile static DoubleLockSingleton INSTANCE;

    private String name = "双重锁检测机制";

    public String getName() {
        return name;
    }

    public static DoubleLockSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (DoubleLockSingleton.class) {
                if (null == INSTANCE) {
                    // 此处可能会出现指令重排序 new对象并不是原子操作
                    INSTANCE = new DoubleLockSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DoubleLockSingleton singleton = DoubleLockSingleton.getInstance();
                System.out.println("实例引用地址：" + singleton + " 实例成员：" + singleton.getName());
            }).start();
        }
    }
}
