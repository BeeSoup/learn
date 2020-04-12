package com.zhangyu.concurrency.Mlearn.process;

/**
 * cmd
 * jps ：获取允许的JAVA进程
 * jstack pid :看状态查看BLOCKED 查看文件，表示等待太多，太多同步操作，竞争很激烈，性能有问题
 *          sun.misc.Unsafe 只能通过反射获取
 */
public class Process1 {

    public static void main(String[] args) throws InterruptedException {
        // Thread 实现Runnable ，如果没有传递Runnable 执行空方法
        //方法引用
        Thread thread = new Thread(Process1::sayGetId);
        //调用方法 可以重复调用，因为是执行一个方法
//        thread.run();
        //启动线程，从而，内部调用run方法，并且会将状态进行改变
        // 不可以重复调用，因为线程不可以重复启动，会因为状态不是处于NEW状态而抛出java.lang.IllegalStateException；
        thread.start();
        thread.join();//等待线程结束
    }

    public static void sayGetId() {
        System.out.println(String.format("线程 [ID-%s]", Thread.currentThread().getId()));
    }
}
