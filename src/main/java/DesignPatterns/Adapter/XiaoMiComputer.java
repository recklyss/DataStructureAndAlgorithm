package DesignPatterns.Adapter;

public class XiaoMiComputer implements TypeCSocketInterface {
    @Override
    public void connectByTypeC() {
        System.out.println("小米笔记本连接 >>> 使用TypeC接口");
    }
}
