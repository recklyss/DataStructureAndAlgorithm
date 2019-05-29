package DesignPatterns.Singleton;

/**
 * @Author zhangjiaheng
 * @Description 普通饿汉型单例 使用classLoader得线程安全机制保证线程安全
 **/
public class HungrySingleton {

    private String name = "我是饿汉型单例";

    public String getName() {
        return this.name;
    }

    public static final HungrySingleton INSTANCE = new HungrySingleton();

    /**
     * 私有构造
     */
    private HungrySingleton() {

    }

    /**
     * 获取类在加载的时候就创建好的实例
     */
    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                HungrySingleton singleton = HungrySingleton.getInstance();
                System.out.println("实例引用地址：" + singleton + " 实例成员：" + singleton.getName());
            }).start();
        }
    }
}
