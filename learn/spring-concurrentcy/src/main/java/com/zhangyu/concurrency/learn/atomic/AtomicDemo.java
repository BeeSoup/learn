package com.zhangyu.concurrency.learn.atomic;


import com.zhangyu.concurrency.learn.annotation.SafeThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性。可见性，有序性
 * 线程安全
 * CAS
 * Unsafe.compareAndSwapInt
 */
@SafeThread
public class AtomicDemo {


    //线程的数量
    private static int threadTotal = 200;
    //客户端的请求的数量
    private static int clientTotal = 5000;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        //产生一个缓存的线程池，使用的是同步队列
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++) {
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        executorService.shutdown();
        System.out.println("over, this count is " + count.get());
    }

    private static void add() {
        count.incrementAndGet();
    }
}
