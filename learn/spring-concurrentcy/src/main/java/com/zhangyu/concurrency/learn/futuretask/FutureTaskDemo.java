package com.zhangyu.concurrency.learn.futuretask;

import com.zhangyu.concurrency.learn.Util.LogUtils;

import java.util.concurrent.*;

/**
 * Callable
 * Runnable
 * Future
 * FutureTask
 */
public class FutureTaskDemo {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {

            LogUtils.log().info("模拟运行");//3

            Thread.sleep(3000);

            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<String> future = executor.submit(new MyCallable());

        //不配置泛型默认Object
        Future<String> future1 = executor.submit(() -> {
            LogUtils.log().info("匿名模拟运行"); //2

            Thread.sleep(5000);

            return "Done1";
        });

//        Future future1 = executor.submit(() -> {
//            LogUtils.log().info("匿名模拟运行");
//
//            Thread.sleep(1000);
//
//            return "Done1";
//        });

        LogUtils.log().info("do some"); // 1
        Thread.sleep(4000);

        LogUtils.log().info(future.get()); // 4秒后直接取到结果
        LogUtils.log().info(future1.get());// 4 + 1 5秒后取到结果
//        提交的时候，就会运行，取结果会阻塞
//10:18:15.691 [main] INFO com.zhangyu.concurrency.learn.Util.LogUtils - do some
//10:18:15.691 [pool-1-thread-2] INFO com.zhangyu.concurrency.learn.Util.LogUtils - 匿名模拟运行
//10:18:15.691 [pool-1-thread-1] INFO com.zhangyu.concurrency.learn.Util.LogUtils - 模拟运行
//10:18:19.696 [main] INFO com.zhangyu.concurrency.learn.Util.LogUtils - Done
//10:18:20.696 [main] INFO com.zhangyu.concurrency.learn.Util.LogUtils - Done1
//10:18:20.696 [main] INFO com.zhangyu.concurrency.learn.Util.LogUtils - is blocking ?
        LogUtils.log().info("is blocking ?"); //是否阻塞 ---会被阻塞，取结果

        executor.shutdown();

    }

}
