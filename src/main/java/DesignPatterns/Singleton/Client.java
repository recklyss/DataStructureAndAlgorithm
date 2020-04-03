package DesignPatterns.Singleton;

import utils.CountDownLatchUtil;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchUtil countDownLatchUtil = new CountDownLatchUtil(200);
        countDownLatchUtil.latch(()->{
            BadSingleton singleton = BadSingleton.getInstance();
            System.out.println("singleton = " + singleton);
        });
    }
}
