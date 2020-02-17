package com.zhangyu.concurrency.learn.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能，用于某段代码只执行一次
 */
public class AtomicBooleanDemo {

    //线程的数量
    private static int threadTotal = 200;
    //客户端的请求的数量
    private static int clientTotal = 5000;

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    public static void main(String[] args) {
        //产生一个缓存的线程池，使用的是同步队列
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    if (isHappened.compareAndSet(false, true)) {
                        test();
                    }
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        executorService.shutdown();
        System.out.println("over, this isHappened is " + isHappened.get());
    }

    private static void test() {
        System.out.println("this test is happened!");
    }
}
