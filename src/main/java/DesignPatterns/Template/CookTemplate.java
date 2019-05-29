package DesignPatterns.Template;

/**
 * @Author zhangjiaheng
 * @Description 做菜的模板类
 **/
public abstract class CookTemplate {

    // 定义步骤为抽象方法

    public abstract void wash();

    public abstract void cook();

    public abstract void finish();

    public final void ComplateCook() {
        System.out.println("开始做菜～");
        wash();
        cook();
        finish();
        System.out.println("完成做菜步骤～");
    }
}
