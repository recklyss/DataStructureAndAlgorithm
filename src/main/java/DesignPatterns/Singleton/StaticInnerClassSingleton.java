package DesignPatterns.Singleton;

/**
 * @Author zhangjiaheng
 * @Description 静态内部类实现单例 类似于饿汉型 但是 是在调用到内部类的时候才会加载 相当于懒汉饿汉合体
 * 也是使用classLoader控制线程安全
 **/
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private String name = "静态内部类单例";

    public String getName() {
        return name;
    }

    private static class SingletonHolder {
        public static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
                System.out.println("实例引用地址：" + singleton + " 实例成员：" + singleton.getName());
            }).start();
        }
    }
}
