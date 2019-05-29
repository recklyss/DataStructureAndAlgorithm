package DesignPatterns.Template;

/**
 * @Author zhangjiaheng
 * @Description 做西红柿炒蛋
 **/
public class XihongshiChaoEgg extends CookTemplate{
    @Override
    public void wash() {
        System.out.println("切西红柿，准备鸡蛋～");
    }

    @Override
    public void cook() {
        System.out.println("炒鸡蛋，然后再炒西红柿～");
    }

    @Override
    public void finish() {
        System.out.println("西红柿炒蛋做好了，出锅～");
    }
}
