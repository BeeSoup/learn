package com.zhangyu.concurrency.learn.countdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 有限的链表也能实现 有限访问数量控制 比如控制数据库链接
 * Semaphore
 * <p>
 * acquire
 * release
 * tryAcquire
 */
public class SemaphoreDemo {

    final static Logger log = LoggerFactory.getLogger(SemaphoreDemo.class);

    final static int threadNum = 5000;
    final static int semaphoreNum = 200;

    final static Semaphore semaphore = new Semaphore(semaphoreNum);

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < threadNum; i++) {
            final int num = i;
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    test(num);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    semaphore.release();
                }
            });
        }

        service.shutdown();

    }

    private static void test(int num) throws Exception {
        Thread.sleep(5000);
        log.info("数量 + {}", num);
    }

}
