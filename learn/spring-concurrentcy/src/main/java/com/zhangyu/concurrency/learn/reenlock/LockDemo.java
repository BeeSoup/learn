package com.zhangyu.concurrency.learn.reenlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
 * sync 使用的时候，在锁定调试的到时候，会被JVM携带来源，从而获取有效的信息
 * <p>
 * <p>
 * lockInterruptibly() 未锁定，就获取锁定，如果已经锁定，就抛出异常
 * isLocked
 *
 * 低竞争sync
 *
 *
 */
public class LockDemo {

    static final Logger log = LoggerFactory.getLogger(LockDemo.class);

    static final int threadNum = 200;

    static int count = 0;

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

    private synchronized static void add() {
        count++;
    }
    /**
     * lock
     * public void lock()
     * 获取锁。
     * 如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。
     * 如果当前线程已经保持该锁，则将保持计数加 1，并且该方法立即返回。
     * 如果该锁被另一个线程保持，则出于线程调度的目的，禁用当前线程，并且在获得锁之前，该线程将一
     * 直处于休眠状态，此时锁保持计数被设置为 1。
     *
     * 指定者：
     * 接口 Lock 中的 lock
     *
     *
     */
    /**
     * lockInterruptibly
     * public void lockInterruptibly() throws InterruptedException
     1）如果当前线程未被中断，则获取锁。

     2）如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。

     3）如果当前线程已经保持此锁，则将保持计数加 1，并且该方法立即返回。

     4）如果锁被另一个线程保持，则出于线程调度目的，禁用当前线程，并且在发生以下两种情况之一以
     前，该线程将一直处于休眠状态：
     1）锁由当前线程获得；或者

     2）其他某个线程中断当前线程。

     5）如果当前线程获得该锁，则将锁保持计数设置为 1。
     如果当前线程：
     1）在进入此方法时已经设置了该线程的中断状态；或者

     2）在等待获取锁的同时被中断。

     则抛出 InterruptedException，并且清除当前线程的已中断状态。


     6）在此实现中，因为此方法是一个显式中断点，所以要优先考虑响应中断，而不是响应锁的普通获取或
     重入获取。

     指定者： 接口 Lock 中的 lockInterruptibly
     抛出：   InterruptedException   如果当前线程已中断。
     *
     */
    /**
     * tryLock    public boolean tryLock()
     *
     * 仅在调用时锁未被另一个线程保持的情况下，才获取该锁。
     *
     * 1）如果该锁没有被另一个线程保持，并且立即返回 true 值，则将锁的保持计数设置为 1。
     * 即使已将此锁设置为使用公平排序策略，但是调用 tryLock() 仍将 立即获取锁（如果有可用的），
     * 而不管其他线程当前是否正在等待该锁。在某些情况下，此“闯入”行为可能很有用，即使它会打破公
     * 平性也如此。如果希望遵守此锁的公平设置，则使用 tryLock(0, TimeUnit.SECONDS)
     * ，它几乎是等效的（也检测中断）。
     *
     * 2）如果当前线程已经保持此锁，则将保持计数加 1，该方法将返回 true。
     *
     * 3）如果锁被另一个线程保持，则此方法将立即返回 false 值。
     *
     * 指定者：
     *    接口 Lock 中的  tryLock
     * 返回：
     *    如果锁是自由的并且被当前线程获取，或者当前线程已经保持该锁，则返回 true；否则返回
     * false
     *
     */
}
