package com.zhangyu.concurrency.Mlearn.process.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/**
 * ReentrantLock 就Synchronized 的API实现 implicit monitor 隐性的
 * <p>
 * ：互斥
 * ：重进入
 * ：隐形的monitor机制
 * <p>
 * 与synchronized 不同点
 * 获得顺序（公平和非公平）
 * 限时锁定（tryLock）
 * 条件对象支持（Condition Support）
 * 运维方法
 * <p>
 * <p>
 * 重进入读写锁：ReentrantLockReadWriteLock : 事物读，读锁共享锁，写锁：独占锁
 * 包含ReentrantLock 所有特性
 * 共享和独占的情况
 * <p>
 * 共享模式 ：复数，就是共享失败， 0就是共享，>0 就是重进入
 * --判断写状态
 * 中断Interruption
 * 降级： 写锁降为读锁 downgrade 关键字搜索 读写锁的Class里面
 *
 * <p>
 * JAVA8
 * 邮票锁：StampedLock 有版本的概念的锁 乐观锁
 * 三种锁：
 * 写
 * 读
 * 优化读
 * <p>
 * Demo Class Point关键字
 */
public class ConcurrencyFramework {

    /**
     * Lock 锁机制
     * 当Thread 进入 synchronized 的时候
     * 1、在Thread (hold lock) ,调用Object#wait() 会释放锁
     * 2、运行期异常的时候，Thread销毁的时候，也会释放
     * 3、Java9 自旋
     * 4、Thread Park的时候 --->LockSupport.park() unsafe.park()
     * 5. Condition#await()
     * 6. Thread.yield()
     * <p>
     * 最佳实践，除非必要，不要设置线程的优先级
     */

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        int holdCount = lock.getHoldCount();
        System.out.printf("holdCount: %d\n", holdCount);
        //不记录历史，只是获取当前的hold的重进入数量
        lock(lock, 10);
        holdCount = lock.getHoldCount();
        System.out.printf("holdCount: %d\n", holdCount);
    }

    public static void tryLockTimeOut() {
        Lock lock = new ReentrantLock();
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    // TODO some
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            //重置标志物
            Thread.currentThread().interrupt();
            // logger message
        }
    }

    public static void lock(Lock lock, int time) {
        try {
            if (time < 0) {
                return;
            }
            lock.lock();
            lock(lock, --time);
        } finally {
            lock.unlock();
        }
    }


    public static void stampLock() {
        StampedLock lock = new StampedLock();
        long stamp = lock.tryOptimisticRead();
        Lock readLock = lock.asReadLock();
        try {
            readLock.lock();
            lock.validate(stamp);

        } finally {
            readLock.unlock();
        }
    }
}
