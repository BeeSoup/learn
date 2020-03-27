package com.zhangyu.concurrency.learn.reenlock;

import com.zhangyu.concurrency.learn.Util.LockUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
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
public class LockDemo8 {

    static final Logger log = LoggerFactory.getLogger(LockDemo8.class);

    static final int threadNum = 200;

    static int count = 0;

    static final ReentrantLock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
//        lock.lock();  1 状态是1 lock等待队列为1
//        condition.await(); 2 锁释放 加入condition的等待队列 state也移过去 0
//        lock.lock() 3 可以被其他获取
//        condition.signalAll(); 发送唤醒 4 将condition的等待队列移过去，但是状态也是1
//        lock.unlock(); 解锁 获取下一个执行，状态降为1

//        唤醒 再lock.unlock
        new Thread(() -> {
            try {
                lock.lock();
                LockUtils.log().info("1: 1");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LockUtils.log().info("1: 5");
                lock.unlock();
                LockUtils.log().info("1: 6");
            }

        }).start();

        new Thread(() ->{
            try{
                lock.lock();
                LockUtils.log().info("2: 2");
                condition.signalAll();
            } finally {
                LockUtils.log().info("2: 3");
                lock.unlock();
                LockUtils.log().info("2: 4");
            }
        }).start();
// unlock的时候，就可以被竞争到
//        17:42:12.445 [Thread-0] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 1: 1
//17:42:12.451 [Thread-1] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 2: 2
//17:42:20.254 [Thread-1] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 2: 3
//17:42:20.905 [Thread-0] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 1: 5
//17:42:27.775 [Thread-1] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 2: 4
//17:42:24.108 [Thread-0] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 1: 6

//        17:44:03.122 [Thread-0] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 1: 1
//17:44:03.126 [Thread-1] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 2: 2
//17:44:03.126 [Thread-1] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 2: 3
//17:44:03.126 [Thread-1] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 2: 4
//17:44:03.126 [Thread-0] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 1: 5
//17:44:03.126 [Thread-0] INFO com.zhangyu.concurrency.learn.Util.LockUtils - 1: 6
    }

    private static void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

}
