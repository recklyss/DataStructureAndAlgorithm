package Alogrithm.Alogrithm.PrintZeroEvenOdd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @Author zhangjiaheng @Description https://leetcode-cn.com/problems/print-zero-even-odd
 * 3个线程交替打印奇偶数和0
 */
public class ZeroEvenOdd {
  private int n;

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  private ReentrantLock lock = new ReentrantLock();
  private Condition c1 = lock.newCondition();
  private Condition c2 = lock.newCondition();
  private Condition c3 = lock.newCondition();
  private volatile int flag = 0;

  public void zero(IntConsumer printNumber) throws InterruptedException {
    try {
      lock.lock();
      for (int i = 1; i <= n; i++) {
        while (flag != 0) {
          c1.await();
        }
        printNumber.accept(i);
        if ((i & 1) == 0) {
          flag = 1;
          c2.signal();
        } else {
          flag = 2;
          c3.signal();
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    try {
      lock.lock();
      for (int i = 1; i <= n; i += 2) {
        while (flag != 1) {
          c2.await();
        }
        printNumber.accept(i);
        flag = 0;
        c1.signal();
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    try {
      lock.lock();
      for (int i = 1; i <= n; i += 2) {
        while (flag != 2) {
          c3.await();
        }
        printNumber.accept(i);
        flag = 0;
        c3.signal();
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
    new Thread(
            () -> {
              try {
                zeroEvenOdd.zero(System.out::print);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            })
        .start();
    new Thread(
            () -> {
              try {
                zeroEvenOdd.even(System.out::print);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            })
        .start();
    new Thread(
            () -> {
              try {
                zeroEvenOdd.odd(System.out::print);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            })
        .start();
  }
}
