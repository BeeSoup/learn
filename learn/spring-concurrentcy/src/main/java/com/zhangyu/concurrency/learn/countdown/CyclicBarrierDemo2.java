package com.zhangyu.concurrency.learn.countdown;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * reset() 可以重置
 * 多个线程相互等待
 * 循环等待结果
 * await() + 1 等待
 * 数字达到设置的值后，再唤醒
 */
public class CyclicBarrierDemo2 {

    //等待一直未到达初始化的整数倍，可能无限等待
    private final static CyclicBarrier barrier = new CyclicBarrier(3);

    final static Logger log = LoggerFactory.getLogger(CyclicBarrierDemo2.class);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int num = i;
            executor.execute(() -> {
                try {
                    race(num);
                } catch (TimeoutException e) {
                    log.error("exception");
                } catch (Exception e) {
                    //TimeoutException 空指针
                    log.error(e.getMessage() == null ? "exception" : e.getMessage(), e);
                }
            });

        }

        executor.shutdown();
    }

    private static void race(int num) throws Exception {
//        Thread.sleep(1000);
        log.info("race + {}", num);
        try {
            barrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (BrokenBarrierException | TimeoutException e) { //时间等待结束，尝试改变状态，异常
            log.warn("BarrierException");
        }
        log.info("continue +  {}", num);
    }
}
