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
 *
 */
public class SemaphoreDemo2 {

    final static Logger log = LoggerFactory.getLogger(SemaphoreDemo2.class);

    final static int threadNum = 20;
    final static int semaphoreNum = 3;


    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(semaphoreNum);
        for (int i = 0; i < threadNum; i++) {
            final int num = i;
            service.execute(() -> {
                try {
                    semaphore.acquire(3); //获取多个许可
                    test(num);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    semaphore.release(3);
                }
            });
        }

        service.shutdown();

    }

    private static void test(int num) throws Exception {
        log.info("数量 + {}", num);
        Thread.sleep(1000);
    }

}
