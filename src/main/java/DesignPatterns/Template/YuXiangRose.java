package DesignPatterns.Template;

/**
 * @Author zhangjiaheng
 * @Description 做鱼香肉丝
 **/
public class YuXiangRose extends CookTemplate{
    @Override
    public void wash() {
        System.out.println("洗胡萝卜～");
        System.out.println("切肉丝～");
    }

    @Override
    public void cook() {
        System.out.println("开始做鱼香肉丝～");
    }

    @Override
    public void finish() {
        System.out.println("鱼香肉丝做好了 出锅～");
    }
}
