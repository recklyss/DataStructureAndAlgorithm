package Alogrithm.Alogrithm.FizzBuzzMultithreaded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzzPrintMain {
    public static void main(String[] args) throws InterruptedException {
        var fizzBuzz = new FizzBuzz(15);
        var threadPool = new ThreadPoolExecutor(
                5, 5, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5), r -> new Thread(r, "某线程"));


        threadPool.execute(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

class FizzBuzz {
    private final int n;
    private final Lock lock = new ReentrantLock();
    private final Condition printFizzCondition = lock.newCondition();
    private final Condition printBuzzCondition = lock.newCondition();
    private final Condition printFizzBuzzCondition = lock.newCondition();
    private final Condition printNumberCondition = lock.newCondition();

    private volatile Boolean shouldPrintNumber;

    public FizzBuzz(int n) {
        this.n = n;
        this.shouldPrintNumber = true;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 15 != 0) {
                while (shouldPrintNumber) {
                    printFizzCondition.await();
                }
                printFizz.run();
            } else {
                shouldPrintNumber = true;
                printNumberCondition.signal();
            }

        }
        lock.unlock();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        for (int i = 1; i <= n; i++) {

            if (i % 5 == 0 && i % 15 != 0) {
                while (shouldPrintNumber) {
                    printBuzzCondition.await();
                }
                printBuzz.run();
            } else {
                shouldPrintNumber = true;
                printNumberCondition.signal();
            }

        }
        lock.unlock();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        for (int i = 1; i <= n; i++) {
            while (shouldPrintNumber) {
                printFizzBuzzCondition.await();
            }
            printFizzBuzz.run();
            if (i % 15 != 0) {
                shouldPrintNumber = true;
                printNumberCondition.signal();
            }
        }
        lock.unlock();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        for (int i = 1; i <= n; i++) {
            while (!shouldPrintNumber) {
                printNumberCondition.await();
            }
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
            }
            if (i % 15 == 0) {
                printFizzBuzzCondition.signal();
                shouldPrintNumber = false;
            }
            if (i % 5 == 0) {
                printBuzzCondition.signal();
                shouldPrintNumber = false;
            }
            if (i % 3 == 0) {
                printFizzCondition.signal();
                shouldPrintNumber = false;
            }
        }
        lock.unlock();
    }
}

class FizzBuzz2 {
    private int n;

    public FizzBuzz2(int n) {
        this.n = n;
    }

    public void fizz(Runnable fizzPrint) {

    }

    public void buzz(Runnable buzzPrint) {

    }

    public void fizzbuzz(Runnable fizzBuzzPrint) {

    }

    public void number(IntConsumer intConsumer) {

    }
}
