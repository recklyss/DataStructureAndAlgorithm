package Alogrithm.Alogrithm.BuildingH2O;

import java.util.Random;
import java.util.concurrent.*;

/** @Author zhangjiaheng @Description 使用信号量控制水分子生成 */
public class H2O_2 {

  private Semaphore hAcquire, oAcquire, hRelease, oRelease;

  public H2O_2() {
    // H 原子线程 请求信号
    hAcquire = new Semaphore(2);
    // O 原子线程 请求信号
    oAcquire = new Semaphore(1);
    // H 原子线程 释放信号
    hRelease = new Semaphore(0);
    // O 原子线程 释放信号
    oRelease = new Semaphore(0);
  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    hAcquire.acquire(); // H线程开始请求
    hRelease.release(); // 通知一个H线程即将释放 因为一个H线程释放最多只有一个O线程等待其释放
    oRelease.acquire(); // 等待O线程释放 一个O线程释放就可以通过
    releaseHydrogen.run();
    hAcquire.release(); // 唤醒H线程请求
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    oAcquire.acquire(); // O线程开始请求
    oRelease.release(2); // 通知一个O线程即将释放 因为一个O线程释放 会有两个H线程等待其释放
    hRelease.acquire(2); // 等待H线程释放 要等待两次释放 才可以通过
    releaseOxygen.run();
    oAcquire.release(); // 唤醒O线程请求
  }

  public static void main(String[] args) {
    String s = "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHOOHHOOOOOHOOOHHHOHHHHOOOHHHOOOHOHOHOHHOHOOHHHOOHOOOHHOOOOHOHHHHOOOOOHHHOOOHOHOHOOOHHOHOOHHOHHHHHHHHHHHHHHHHHHHHHHHHHHH";
    final H2O_2 o = new H2O_2();
    ThreadPoolExecutor pool =
        new ThreadPoolExecutor(
            300,
            300,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
                (ThreadFactory) Thread::new);
    for (char c : s.toCharArray()) {
      if (c == 'H') {
        pool.execute(
            () -> {
              try {
                Thread.sleep(new Random().nextInt(10));
                o.hydrogen(() -> System.out.print("H"));
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
      } else {
        pool.execute(
            () -> {
              try {
                Thread.sleep(new Random().nextInt(10));
                o.oxygen(() -> System.out.print("O"));
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
      }
    }
  }
}
