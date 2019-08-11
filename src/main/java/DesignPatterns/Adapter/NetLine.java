package DesignPatterns.Adapter;

public class NetLine {

    /**
     * 网线只有普通网卡连接
     */
    private NICSocketInterface socket;

    public void setSocket(NICSocketInterface socket) {
        this.socket = socket;
    }

    public void connect(){
        System.out.println("连接电脑~");
        socket.connectByNIC();
    }
}
