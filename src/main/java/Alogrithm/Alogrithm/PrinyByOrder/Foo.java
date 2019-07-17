package Alogrithm.Alogrithm.PrinyByOrder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程 按序打印
 */
public class Foo {

    public Foo() {

    }

    private ReentrantLock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    private int state = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            lock.lock();
            if (state != 1) {
                c1.await();
            }
            state = 2;
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();
            if (state != 2) {
                c2.await();
            }
            state = 3;
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            lock.lock();
            if (state != 3) {
                c3.await();
            }
            state = 1;

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}