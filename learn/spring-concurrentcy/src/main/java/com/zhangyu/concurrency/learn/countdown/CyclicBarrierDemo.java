package com.zhangyu.concurrency.learn.countdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * reset() 可以重置
 * 多个线程相互等待
 * 循环等待结果
 * await() + 1 等待
 * 数字达到设置的值后，再唤醒
 */
public class CyclicBarrierDemo {

    //等待一直未到达初始化的整数倍，可能无限等待
    private static final CyclicBarrier barrier = new CyclicBarrier(5);

    static final Logger log = LoggerFactory.getLogger(CyclicBarrierDemo.class);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int num = i;
            executor.execute(() -> {
                try {
                    race(num);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            });

        }

        executor.shutdown();
    }

    private static void race(int num) throws Exception {
        log.info("race + {}", num);
        Thread.sleep(1000);
        barrier.await();
        log.info("continue +  {}", num);
    }
}
