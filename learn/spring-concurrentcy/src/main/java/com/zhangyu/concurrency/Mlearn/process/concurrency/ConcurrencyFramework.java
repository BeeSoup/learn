package com.zhangyu.concurrency.Mlearn.process.concurrency;

/**
 * ReentrantLock 就Synchronized 的API实现 implicit monitor 隐性的
 *
 *  ：互斥
 *  ：重进入
 *  ：隐形的monitor机制
 *
 *  与synchronized 不同点
 *   获得顺序（公平和非公平）
 *   限时锁定（tryLock）
 *   条件对象支持（Condition Support）
 *   运维方法
 *
 *
 * 重进入读写锁：ReentrantLockReadWriteLock : 事物读，读锁共享锁，写锁：独占锁
 *
 * 邮票锁：StampedLock 有版本的概念的锁 乐观锁
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
     *
     * 最佳实践，除非必要，不要设置线程的优先级
     */


}
