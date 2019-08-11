package DesignPatterns.Adapter;

public class NormalNICSocket implements NICSocketInterface {
    @Override
    public void connectByNIC() {
        System.out.println("普通NIC接口 >>> 使用普通网卡连接");
    }
}
