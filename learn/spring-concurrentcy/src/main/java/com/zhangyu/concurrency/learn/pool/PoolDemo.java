package com.zhangyu.concurrency.learn.pool;

/**
 * 线程池：
 *       重用存在的线程，减少对象的创建、消亡的开销，性能佳
 *       控制最大并发线程数，提高系统资源利用率，同时可以避免过多的资源竞争，避免阻塞
 *       提供定时执行，定时执行，单线程
 *       ThreadPoolExecutor
 *        :corePoolSize 核心线程
 *        maximumPoolSize 最大线程数
 *        workQueue 阻塞队列，存储等待任务
 *  运行的线程数少于   corePoolSize时，即使有空闲线程也创建新线程
 *  线程大于等于corePoolSize时 且小于maximumPoolSize 只有workQueue满的时候才创建新线程去执行
 *  如果线程等于maximumPoolSize且workQueue 也满的时候，那么就有拒绝策略
 *  所以，当workQueue无界的时候，线程数，是固定且等于corePoolSize
 *
 *         keepAliveTime: 线程没有任务执行时最多保持多久时间终止 空闲时间
 *                  线程数量大于corePoolSize的时候，等待销毁
 *         unit 上面的单位
 *         threadFactory: 线程工厂，用来创建线程
 *         rejectHandler: 拒绝策略
 *                        1、直接抛出异常---默认
 *                        2、用调用者的线程执行任务
 *                        3、丢弃最靠前的任务并执行当前任务
 *                        4、丢弃这个任务
 *
 *
 * running 可以一切
 * shutdown  不接受提交任务，但是已经提交的弄弄 完
 * stop 不接受，也不处理
 * tidying 已经终止，并且线程运行的线程为0
 * terminated terminated() 进入终止
 *
 *
 *  execute() 提交任务
 *  submit()  提交任务 = execute + Future
 *  shutdown
 *  shutdownNow
 *
 *  getTaskCount(): 线程池已经执行和未执行的任务总数
 *  getCompletedTaskCount: 已经完成的任务总数
 *  getPoolSize 当前线程池的线程数量
 *  getActiveCount() :当前线程池中正在执行的线程数量
 *
 *  Executors.newCachedThreadPool    可以缓存的
 *           .newFixedThreadPool     定长的线程池
 *           .newScheduledThreadPool  定长定时周期执行线程池
 *           .newSingleThreadPool    单线程线程池 ，执行，先入先出，优先级等等
 *
 *
 */
public class PoolDemo {
}
