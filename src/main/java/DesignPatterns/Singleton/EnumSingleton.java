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
}
