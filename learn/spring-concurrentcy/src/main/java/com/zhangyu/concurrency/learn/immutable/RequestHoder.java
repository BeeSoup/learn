package com.zhangyu.concurrency.learn.immutable;

import com.sun.org.apache.regexp.internal.RE;

public class RequestHoder {

    private final static ThreadLocal<Long> requestHoder = new ThreadLocal<>();



    //默认Key是线程的ID ，Value 是这个Long id
    public static void add(Long id) {
        requestHoder.set(id);
    }

    public static Long get() {
        return requestHoder.get();
    }

    public static void remove() {
        requestHoder.remove();
    }
}
