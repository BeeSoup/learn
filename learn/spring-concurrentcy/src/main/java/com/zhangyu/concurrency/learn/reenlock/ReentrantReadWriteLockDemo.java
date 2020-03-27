package com.zhangyu.concurrency.learn.reenlock;

import com.zhangyu.concurrency.learn.Util.LogUtils;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁 由读锁和写锁组成
 * 没有读写锁的情况下才能取货到写锁
 * <p>
 * 在读操作很多的情况下，可能会引起 写锁的饥饿，迟迟等待读锁
 */
public class ReentrantReadWriteLockDemo {

    static final Map<String, String> map = new TreeMap<>();

    static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    static final Lock readLock = lock.readLock();

    static final Lock writeLock = lock.writeLock();

    public static void main(String[] args) {
        LogUtils.log().info("start");


    }

}
