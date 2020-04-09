package com.zhangyu.concurrency.Mlearn.process;

/**
 * 进程、线程、协程
 * 进程
 * <JAVA5 : Thread Runnable
 * JAVA5 : Executor Future Callable
 * JAVA7 : ForkJoin
 * JAVA8 : CompletionStage CompletableFuture
 * <p>
 * 线程池
 * JAVA5+: ExecutorService
 * ThreadPoolExecutor
 * ScheduledTheadPoolExecutor
 * JAVA7+ : ForkJoinPool
 * <p>
 * 并发框架：
 * JAVA5  JAVA Util Concurrent
 * JAVA7  Fork/Join
 * JAVA8  CompletableFuture、RxJava、Reactor
 * <p>
 * 同步： 任务发起方和执行方为同一个线程
 * 异步： 任务发起方和执行方为不同线程、、、、常见提升吞吐量的手段
 * <p>
 * 1 ： true
 * 0 : false
 * >1 : false
 * <p>
 * <p>
 * 线程：
 * NEW ，线程创建未启动
 * RUNNABLE ,处于可运行，不一定运行
 * BLOCKED , 被Monitor锁阻塞，表示当前在同步锁场景运作
 * WAITING, 线程处于等待状态
 * TIMED_WAITING，线程处于规定时间的等待
 * TERMINATED，线程结束，但是不是被销毁，线程，只有被gc了，才会被销毁
 */
public class Process {

    public static void main(String[] args) throws InterruptedException {
        // Thread 实现Runnable ，如果没有传递Runnable 执行空方法
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("线程 [ID-%s]", Thread.currentThread().getId()));
            }
        });
        //调用方法 可以重复调用，因为是执行一个方法
//        thread.run();
        //启动线程，从而，内部调用run方法，并且会将状态进行改变
        // 不可以重复调用，因为线程不可以重复启动，会因为状态不是处于NEW状态而抛出java.lang.IllegalStateException；
        thread.start();
        thread.join();//等待线程结束
    }
}
