package DesignPatterns.Singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author zhangjiaheng
 * @Description 使用CAS实现单例 线程安全
 **/
public class CASSingleton {

    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    private CASSingleton() {
    }

    private String name = "CAS单例";

    public String getName() {
        return name;
    }

    /**
     * 使用原子操作 实现获取唯一实例
     * 理论上在大量竞争的环境中 原子操作自旋等待消耗大量性能 但是实际上当一个线程创建好实例之后其余线程不会出现死循环
     * 相对于锁它没有线程切换和阻塞的额外消耗,可以支持较大的并行度
     */
    public static CASSingleton getInstance() {
        for (; ; ) {
            CASSingleton instance = INSTANCE.get();
            if (null != instance) {
                return instance;
            }
            instance = new CASSingleton();
            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CASSingleton singleton = CASSingleton.getInstance();
                System.out.println("实例引用地址：" + singleton + " 实例成员：" + singleton.getName());
            }).start();
        }
    }
}
