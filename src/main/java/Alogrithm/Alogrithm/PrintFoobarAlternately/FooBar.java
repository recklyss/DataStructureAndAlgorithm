package Alogrithm.Alogrithm.PrintFoobarAlternately;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/** @Author zhangjiaheng @Description 交替打印FooBar */
public class FooBar {
  private int n;

  public FooBar(int n) {
    this.n = n;
  }

  private ReentrantLock lock = new ReentrantLock();

  private Condition c1 = lock.newCondition();
  private Condition c2 = lock.newCondition();

  private volatile boolean flag = false;

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {
        try {
            lock.lock();
            if (flag) {
                c1.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = !flag;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {
        try {
            lock.lock();
            if (!flag) {
                c2.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = !flag;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
  }
}
