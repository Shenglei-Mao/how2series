import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    Lock lock = new ReentrantLock();
//    volatile boolean first = false;
//    volatile boolean second = false;
    boolean first = false;
    boolean second = false;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        first = true;
        printFirst.run();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(first != true) {

        }
        lock.lock();
        printSecond.run();
        second = true;
        lock.unlock();

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(second != true) {

        }
        lock.lock();
        printThird.run();
        lock.unlock();

    }
}