package com.zhangyu.concurrency.learn.concurrencycontainer;


import java.util.Set;
import java.util.concurrent.*;

public class CopyOnWriteSetDemo {

    //线程的数量
    private static int threadTotal = 200;
    //客户端的请求的数量
    private static int clientTotal = 5000;

//    private static Set count = new ConcurrentSkipListSet();
    private static Set count = new CopyOnWriteArraySet();

    public static void main(String[] args) throws InterruptedException {
        //产生一个缓存的线程池，使用的是同步队列
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int index = 0; index < clientTotal; index++) {
            final int threadNum = index;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    put(threadNum);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            });
        }
        //阻塞进程，当进程进程执行减一到零后，主线重新被唤醒
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("over, this size is " + count.size());

    }

    private static void put(int num) {
        count.add(num);
    }
}
