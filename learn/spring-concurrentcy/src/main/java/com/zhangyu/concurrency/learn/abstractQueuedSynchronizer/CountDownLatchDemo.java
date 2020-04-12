package com.zhangyu.concurrency.learn.abstractQueuedSynchronizer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch阻塞测试
 */
public class CountDownLatchDemo {

    private static int ThreadCount = 500;

    private static CountDownLatch latch = new CountDownLatch(ThreadCount);

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(() -> {
            int i = 0;
            System.out.println(i);

        });

        service.shutdown();

    }
}
