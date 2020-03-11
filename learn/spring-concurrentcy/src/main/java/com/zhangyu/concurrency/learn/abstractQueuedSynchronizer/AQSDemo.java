package com.zhangyu.concurrency.learn.abstractQueuedSynchronizer;

/**
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
