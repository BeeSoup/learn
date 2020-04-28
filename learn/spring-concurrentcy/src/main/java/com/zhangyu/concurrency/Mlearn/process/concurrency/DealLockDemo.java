package com.zhangyu.concurrency.Mlearn.process.concurrency;

public class DealLockDemo {


    public static final Object lock1 = new Object();

    public static final Object lock2 = new Object();


    //相互等待
    public static void main(String[] args) {
        new Thread(() -> {

            synchronized (lock1) {

                synchronized (lock2) {

                }


            }


        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {

                }
            }
        }).start();
    }
}
