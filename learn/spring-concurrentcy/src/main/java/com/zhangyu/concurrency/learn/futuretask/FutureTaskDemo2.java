package com.zhangyu.concurrency.learn.futuretask;

import com.zhangyu.concurrency.learn.Util.LogUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable
 * Runnable
 * Future
 * FutureTask
 */
public class FutureTaskDemo2 {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {

            LogUtils.log().info("模拟运行");//3

            Thread.sleep(3000);

            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<String> task = new FutureTask<>(() -> {

            LogUtils.log().info("futureTask is try");

            Thread.sleep(3000);

            return "OK";
        });
        new Thread(task).start();

        LogUtils.log().info("main is try");

        Thread.sleep(1000);

        LogUtils.log().info(task.get());

        LogUtils.log().info("main is Done");

//        10:25:26.347 [main] INFO com.zhangyu.concurrency.learn.Util.LogUtils - main is try
//10:25:26.347 [Thread-0] INFO com.zhangyu.concurrency.learn.Util.LogUtils - futureTask is try
//10:25:29.355 [main] INFO com.zhangyu.concurrency.learn.Util.LogUtils - OK
//10:25:29.355 [main] INFO com.zhangyu.concurrency.learn.Util.LogUtils - main is Done

//        executor.shutdown();

    }

}
