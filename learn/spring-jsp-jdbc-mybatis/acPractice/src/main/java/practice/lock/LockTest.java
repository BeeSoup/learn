package practice.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    //lock-free 可见性
    private volatile static int data;

    // 乐观锁 CAS
    private AtomicInteger integer;

    public synchronized void doSome() {
        Lock lock = new ReentrantLock();

        try {
            lock.tryLock();

        } finally {
            lock.unlock();

        }

    }
}
