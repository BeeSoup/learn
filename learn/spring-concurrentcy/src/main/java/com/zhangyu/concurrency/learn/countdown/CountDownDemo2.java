package com.zhangyu.concurrency.learn.countdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownDemo2 {
    private static Logger log = LoggerFactory.getLogger(CountDownDemo2.class);

    static final int threadNum = 200;

    static boolean flag = true;

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

        //可以给定等待时间 如果未获取到结果就结束
        latch.await(10, TimeUnit.MILLISECONDS);
        executor.shutdown();
//        executor.shutdownNow();

        flag = false;
        //线程不安全
        log.info("结果 + {}", count);
    }

    private static void test(int num) throws Exception {
        Thread.sleep(5);
        if (flag) {
            count++;
            log.info("数量 + {}", num);
        } else {
            log.info("else");
        }
    }
}
