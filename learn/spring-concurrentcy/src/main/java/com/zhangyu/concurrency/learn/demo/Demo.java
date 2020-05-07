package com.zhangyu.concurrency.learn.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class Demo {
    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();


    public static void main(String[] args) {
        Future<Integer> future = executor.submit(new MyCallable()); //callable 会被线程池封装，在future.get()的时候，才会被抛出
        try {
            System.out.printf("结果为 : %d\n" , future.get());
        } catch (InterruptedException e) {
            System.out.println("中断！");
        } catch (ExecutionException e) {
            logger.error(e.getMessage(), e);
            System.out.println("异常！");
        } catch (CancellationException e) {
            System.out.println("取消！");
        }
        executor.execute(new MyRunnable());//会直接抛出

        executor.shutdown();

        //[main] ERROR com.zhangyu.concurrency.learn.demo.Demo - java.lang.ArithmeticException: / by zero
        //java.util.concurrent.ExecutionException: java.lang.ArithmeticException: / by zero
        //	at java.util.concurrent.FutureTask.report(FutureTask.java:122)
        //	at java.util.concurrent.FutureTask.get(FutureTask.java:192)
        //	at com.zhangyu.concurrency.learn.demo.Demo.main(Demo.java:17)
        //Caused by: java.lang.ArithmeticException: / by zero
        //	at com.zhangyu.concurrency.learn.demo.Demo$MyCallable.call(Demo.java:39)
        //	at com.zhangyu.concurrency.learn.demo.Demo$MyCallable.call(Demo.java:33)
        //	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        //	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        //	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        //	at java.lang.Thread.run(Thread.java:748)
        //异常！
        //Exception in thread "pool-1-thread-1" java.lang.ArithmeticException: / by zero
        //	at com.zhangyu.concurrency.learn.demo.Demo$MyRunnable.run(Demo.java:52)
        //	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        //	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        //	at java.lang.Thread.run(Thread.java:748)
    }


    private static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 4; i >= 0; i--) {
                sum = sum + (12 / i);
            }
            return sum;
        }
    }

    private static class MyRunnable implements Runnable {


        @Override
        public void run() {
            int sum = 0;
            for (int i = 4; i >= 0; i--) {
                sum = sum + (12 / i);
            }
        }
    }
}
