package DesignPatterns.Singleton;

/**
 * @Author zhangjiaheng
 * @Description 懒汉型单例 线程不安全
 **/
public class LazySingleton {

    private static LazySingleton INSTANCE ;

    private LazySingleton(){

    }

    private String name = "懒汉型单例";

    public static LazySingleton getInstance(){
        if(null == INSTANCE){
            synchronized (LazySingleton.class){
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }

    private String getName() {
        return name;
    }
}
