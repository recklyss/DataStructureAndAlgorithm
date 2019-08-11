package DesignPatterns.Adapter;

public class Client {

    public static void main(String[] args) {

        XiaoMiComputer computer = new XiaoMiComputer();

        SocketAdapter adapter = new SocketAdapter();
        adapter.setSocket(computer);

        NetLine line = new NetLine();
        line.setSocket(adapter);
        line.connect();
    }
}
