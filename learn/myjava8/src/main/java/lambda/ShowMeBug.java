package com.zy.learn.lambda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO...
 *
 * @author zhang
 * @since 2021/2/21
 */
@Slf4j
public class ShowMeBug {
    private double balance; // 账户余额

    private final static Object obj = new Object();

    /**
     * 存款
     *
     * @param money 存入金额
     */
    public void deposit(double money) {
        // 请输入实现存钱逻辑
        synchronized (obj) {
            this.balance += money;
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }


    public static void main(String[] args) throws InterruptedException {
        // 100个线程同时向一个银行账户中存入一元钱
        BlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue<>(100);
        ThreadFactory threadFactory = new CustomizableThreadFactory("save-money");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1L, TimeUnit.MINUTES, blockQueue, threadFactory);
        final ShowMeBug showMeBug = new ShowMeBug();
        final CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    showMeBug.deposit(1.0);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                } finally {
                    latch.countDown();
                }
            });
        }

        executor.shutdown();

        latch.await();
        double balance = showMeBug.balance;
        log.info(balance + "");
    }

}
