package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final static Lock lock = new ReentrantLock();
    public static void outerMethod(){
        try {
            lock.lockInterruptibly();
            System.out.println("Outer lock executed");
            innerMethod();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void innerMethod() {
        try {
            lock.lock();
            System.out.println("Inner method executed");
        } finally {
            lock.unlock();
        }
    }

    static void main(String[] args) {
        outerMethod();
    }
}
