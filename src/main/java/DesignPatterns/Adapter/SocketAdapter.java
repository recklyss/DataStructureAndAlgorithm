package DesignPatterns.Adapter;

public class SocketAdapter implements NICSocketInterface {
    private TypeCSocketInterface socket;

    public void setSocket(TypeCSocketInterface socket) {
        this.socket = socket;
    }

    @Override
    public void connectByNIC() {
        System.out.println("--- 适配器连接开始 ---");
        socket.connectByTypeC();
        System.out.println("--- 适配器连接结束 ---");
    }
}
