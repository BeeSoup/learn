package com.zhangyu.concurrency.learn.reenlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * JAVA 主要分两类锁
 * ReentrantLock JDK实现 用户
 * synchronized(自增，也是可以重入 ,JVM实现) JUC里提供的锁 操作系统
 * <p>
 * 可重入性
 * 实现
 * 性能的区别，在引用偏向锁，倾向级(自旋锁)循环调用CAS操作实现加锁避免进入内核态的阻塞     差不多了
 * 功能： 便利性 synchronized 由编译器，去实现加锁和释放 ReentrantLock 自定义
 * 细粒度 ReentrantLock优于synchronized
 * 独立功能： 指定公平和非公平锁 而synch ->只能是非公平 （先等待，不一定先获取）
 * 提供了Condition（条件）类，可以分组唤醒需要唤醒的线程
 * 提供中断等待锁的机制 lock.lockInterruptibly()
 * <p>
 * synch 使用的时候，在锁定调试的到时候，会被JVM携带来源，从而获取有效的信息
 */
public class LockDemo3 {

    static final Logger log = LoggerFactory.getLogger(LockDemo3.class);

    static final int threadNum = 200;

    static int count = 0;

    static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        final CountDownLatch latch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executor.execute(() -> {
                add();
                latch.countDown();
            });
        }
        latch.await();
        executor.shutdown();
        log.info("count = {}", count);
    }

    private static void add() {
        if (lock.tryLock()) {
            try {
                count++;
            } finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }

}
