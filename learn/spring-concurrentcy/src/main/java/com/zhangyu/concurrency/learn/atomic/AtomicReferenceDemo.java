package com.zhangyu.concurrency.learn.atomic;


import com.zhangyu.concurrency.learn.annotation.SafeThread;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 */
@SafeThread
public class AtomicReferenceDemo {

    private static AtomicReference<Integer> reference = new AtomicReference<>(0);

    private static AtomicIntegerFieldUpdater<AtomicReferenceDemo> update =
            AtomicIntegerFieldUpdater.newUpdater(AtomicReferenceDemo.class, "count");

    private static AtomicReferenceDemo demo = new AtomicReferenceDemo();

    //必须是被volatile 修饰，并且不为static
    private volatile int count = 100;

    public static void main(String[] args) {
        reference.compareAndSet(0, 2);//2
        reference.compareAndSet(0, 3);//no
        reference.compareAndSet(0, 4);//no
        reference.compareAndSet(0, 5);//no
        reference.compareAndSet(2, 7); // 7
        System.out.println(reference.get());


        if (update.compareAndSet(demo, 100, 120)) {
            System.out.println("success is " + demo.count);
        } else {
            System.out.println("failure is " + demo.count);
        }

        if (update.compareAndSet(demo, 100, 140)) {
            System.out.println("success is " + demo.count);
        } else {
            System.out.println("failure is " + demo.count);
        }

    }
}
