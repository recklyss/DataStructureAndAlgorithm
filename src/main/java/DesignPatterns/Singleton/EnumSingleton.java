package DesignPatterns.Singleton;

/**
 * @Author zhangjiaheng
 * @Description 枚举类单例
 **/
public enum EnumSingleton {

    INSTANCE;

    private String name = "枚举型单例";

    private String getName() {
        return name;
    }

    public static EnumSingleton getInstance() {
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
                EnumSingleton singleton = EnumSingleton.getInstance();
                System.out.println("实例：" + singleton.hashCode() + " 实例成员：" + singleton.getName());
            }).start();
        }
    }
}
