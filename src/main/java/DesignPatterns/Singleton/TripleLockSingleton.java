package DesignPatterns.Singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zhangjiaheng
 * @Description 三重锁检测机制实现线程安全单例 包括了volatile
 **/
public class TripleLockSingleton {

    private TripleLockSingleton() {
    }

    /**
     * 使用volatile屏蔽分配对象时的指令重排序
     */
    private volatile static TripleLockSingleton INSTANCE;

    private String name = "双重锁检测机制";

    public String getName() {
        return name;
    }

    public static TripleLockSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (TripleLockSingleton.class) {
                if (null == INSTANCE) {
                    // 此处可能会出现指令重排序 new对象并不是原子操作
                    INSTANCE = new TripleLockSingleton();
                }
            }
        }
        return INSTANCE;
    }

    private static int N = 1000;
    private static CountDownLatch start = new CountDownLatch(N);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < N; i++) {
            new Thread(() -> {
                try {
                    start.await();
                    Thread.sleep(1000);
                    TripleLockSingleton singleton = TripleLockSingleton.getInstance();
                    System.out.println(singleton);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                }
            }).start();
            start.countDown();
        }
    }
}
