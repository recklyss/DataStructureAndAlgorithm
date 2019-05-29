package DesignPatterns.Template;

/**
 * @Author zhangjiaheng
 * @Description 客户端调用
 **/
public class Client {

    public static void main(String[] args) {
        CookTemplate cook = new XihongshiChaoEgg();
        cook.ComplateCook();
        cook = new YuXiangRose();
        cook.ComplateCook();
    }
}
