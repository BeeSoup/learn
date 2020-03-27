package com.zhangyu.concurrency.learn.futuretask;

/**
 * 阻塞队列
 * 满了：入队列
 * 空了：出队列
 *            ---> 阻塞
 *            用于生产和消费
 *          throws exception       special Value   blocks
 *  insert       add               offer           put
 *  Remove      remove              poll           task
 *  examine     element             peek
 *
 *
 *  ArrayBlockingQueue 有界阻塞队列，内部是数组FIFO
 *  DelayQueue 阻塞内部元素实现 需要排序，定时
 *  LinkedBlockingQueue 可指定大小， 链表 FIFO
 *  PriorityBlockingQueue 优先级Queue，无边界有排序规则，允许插入null 对象需要实现Prioritable接口
 *                                                  对接口实现排序
 *  SynchronousQueue 只允许一个元素，同步队列
 */
public class BlockQueueDemo {
}
