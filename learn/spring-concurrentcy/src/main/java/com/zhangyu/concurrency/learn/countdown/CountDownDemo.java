package com.zhangyu.concurrency.learn.countdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * countDown
 * 一个线程等待其他线程完成
 * await 核心方法
 */
public class CountDownDemo {
    private static Logger log = LoggerFactory.getLogger(CountDownDemo.class);

    final static int threadNum = 200;

    static int count;

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(threadNum);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNum; i++) {
            final int num = i;
            executor.execute(() -> {
                try {
                    test(num);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    //可以用在条件中
                    latch.countDown();
                }
            });
        }
        executor.shutdown();

        latch.await();

        //线程不安全
        log.info("结果 + {}", count);
    }

    private static void test(int num) throws Exception {
        Thread.sleep(100);
        count++;
        log.info("数量 + {}", num);
        Thread.sleep(100);
    }
}
