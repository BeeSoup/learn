package com.zhangyu.concurrency.learn.abstractQueuedSynchronizer;

/**
 *
 * 四种进程或线程同步互斥的控制方法
 * 临界区: 通过对多线程的串行化来访问公共资源的一段代码，速度快，适合控制数据访问。
 * 互斥量: 为协调共同对一个共享资源的单独访问而设计的。
 *                               --  直接申请访问互斥量的为重量锁
 *                               --  先通过CAS更新指向线程栈中的Lock Record 成功才访问互斥量，从而减少竞争
 * 信号量: 为控制一个具有有限数量用户资源而设计。
 * 事 件: 用来通知线程有一些事件已发生，从而启动后继任务的开始。
 *
 * 偏向锁假定将来只有第一个申请锁的线程会使用锁（不会有任何线程再来申请锁）
 * ，因此，只需要在Mark Word中CAS记录owner（本质上也是更新，但初始值为空），
 * 如果记录成功，则偏向锁获取成功，记录锁状态为偏向锁，
 * 以后当前线程等于owner就可以零成本的直接获得锁；否则，说明有其他线程竞争，膨胀为轻量级锁。
 * 偏向锁无法使用自旋锁优化，因为一旦有其他线程申请锁，就破坏了偏向锁的假定。
 *
 *
 *
 * 模版方法
 * AQS 基于FIFO的队列 使用Node实现
 * 双向链表的锁      syncQueue head用于调度
 *                   conditionQueue 单链queue
 *
 *  利用int state表示状态：ReentrantLock
 *
 * 0: 没有线程获取锁
 * 1：已经有线程获取到锁
 * >1： 重入锁的数量
 * 使用方法是继承
 * acquire And release 管理状态
 * 可以实现排它锁和共享锁的模式（独占和共享） 一般使用其中之一子类继承
 *
 *
 * 首先先尝试获取锁，如果失败，就将线程以及等待信息包装一个节点Node,加入队列 sync Queue
 * 循环尝试获取锁 当前节点为Head,失败就后记，然后等待唤醒
 *
 * 线程调度----Con
 * AQS 同步组件 ： CountDownLatch/Semaphore/CyclicBarrier
 *                 ReentrantLock/ Condition/FutureTask
 * CountDownLatch 可以让多个线程处于等待状态，并且只允许执行一遍，也就是意味着，循环次数，不可重置
 * 条件计算处理完成，才会触发等待线程
 *
 */
public class AQSDemo {
}
