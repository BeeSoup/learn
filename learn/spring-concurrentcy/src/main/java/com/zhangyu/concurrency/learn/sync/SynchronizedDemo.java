package com.zhangyu.concurrency.learn.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized 关键字的测试
 *
 *  synchronized 不属于被声明的部分，所有，不会被子类所继承，如果要使用，需要子类重新添加
 */
public class SynchronizedDemo {


    /**
     * 作用于代码块，作用的对象是调用对象
     */
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test1" + ",  " + j + "   " + i);
            }
        }
    }

    /**
     * 作用于整个方法，作用的对象是调用对象
     */
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println("test2" + i);
        }
    }


    /**
     * 作用于整个方法，作用的对象是所有的对象
     */
    public synchronized static void test3(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println("test3 -"  + j + " " +i);
        }
    }

    /**
     * 作用于一个对象，作用的对象是所有的对象
     */
    public void test4(int j) {
        synchronized (SynchronizedDemo.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test4 - " + ",  " + j + "   " + i);
            }
        }
    }


    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        SynchronizedDemo demo1 = new SynchronizedDemo();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            demo.test1(1);
        });
        service.execute(() -> {
            demo.test1(2);
        });

        service.execute(() -> {
            demo.test2();
        });
        service.execute(() -> {
            demo.test2();
        });

        service.execute(() -> {
            demo.test1(1);
        });
        service.execute(() -> {
            demo1.test1(2);
        });

        service.shutdown();

    }
}
