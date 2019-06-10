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

    public synchronized static LazySingleton getInstance(){
        if(null == INSTANCE){
            INSTANCE = new LazySingleton();
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
                LazySingleton singleton = LazySingleton.getInstance();
                System.out.println("实例引用地址：" + singleton + " 实例成员：" + singleton.getName());
            }).start();
        }
    }

    private String getName() {
        return name;
    }
}
