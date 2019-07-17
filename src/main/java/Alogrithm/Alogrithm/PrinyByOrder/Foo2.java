package Alogrithm.Alogrithm.PrinyByOrder;

public class Foo2 {

    private volatile int state = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        while (state != 1) {

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        state = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (state != 2) {

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        state = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (state != 3) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        state = 1;
    }
}
