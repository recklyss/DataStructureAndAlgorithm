package DesignPatterns.Singleton;

/**
 * @Author zhangjiaheng
 * @Description 静态内部类实现单例 类似于饿汉型 但是 是在调用到内部类的时候才会加载 相当于懒汉饿汉合体
 * 也是使用classLoader控制线程安全
 **/
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private static class SingletonHolder {
        public static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
