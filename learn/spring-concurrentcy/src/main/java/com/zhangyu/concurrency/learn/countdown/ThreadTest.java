/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/4/1  zhangyu30939  新增
 * ========    =======  ============================================
 */
package com.zhangyu.concurrency.learn.countdown;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-04-01
 */
public class ThreadTest {

    static BlockingQueue<String> queueList = new LinkedBlockingQueue<>();

    static final int threadNum = 5;

    // 5个线程
    static final CountDownLatch latch = new CountDownLatch(threadNum);


    public static void main(String[] args) throws InterruptedException {


        ExecutorService executor = Executors.newCachedThreadPool();
//        executor.execute(() -> {
//
//        });
        executor.execute(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    queueList.put(i + "");
                }
                queueList.put("closed");
                queueList.put("closed");
                queueList.put("closed");
                queueList.put("closed");
                queueList.put("closed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new ThreadDeal());
        }

        executor.shutdown();
        latch.await();
    }

    static class ThreadDeal implements Runnable {
        private boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                Object take = null;
                try {
                    take = queueList.take();
                    if (Objects.equals("closed", take)) {
                        this.flag = false;
                        break;
                    }
                    // 业务逻辑
                    System.out.println(take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            latch.countDown();
        }
    }
}
