package DesignPatterns.Singleton;

/**
 * @Author zhangjiaheng
 * @Description 双重锁检测机制实现线程安全单例
 **/
public class DoubleLockSingleton {

    private DoubleLockSingleton() {
    }

    private static volatile DoubleLockSingleton INSTANCE;

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
}
