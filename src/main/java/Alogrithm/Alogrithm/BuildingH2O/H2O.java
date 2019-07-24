package Alogrithm.Alogrithm.BuildingH2O;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/** @Author zhangjiaheng @Description 水分子生成 */
public class H2O {
  public H2O() {}

  private ReentrantLock lock = new ReentrantLock();

  private Condition H = lock.newCondition();
  private Condition O = lock.newCondition();

  private volatile int hCount = 0;

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    try {
      lock.lock();
      while (hCount == 2) {
        H.await();
      }
      hCount++;
      releaseHydrogen.run();
      if (hCount == 2) {
        O.signal();
      } else {
        H.signal();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    try {
      lock.lock();
      while (hCount != 2) {
        O.await();
      }
      hCount = 0;
      releaseOxygen.run();
      H.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    String s = "HHOOOHHHH";
    final H2O o = new H2O();
    for (char c : s.toCharArray()) {
      if (c == 'H') {
        new Thread(
                () -> {
                  try {
                    o.hydrogen(() -> System.out.print("H"));
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                })
            .start();
      } else {
        new Thread(
                () -> {
                  try {
                    o.oxygen(() -> System.out.print("O"));
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                })
            .start();
      }
    }
  }
}
