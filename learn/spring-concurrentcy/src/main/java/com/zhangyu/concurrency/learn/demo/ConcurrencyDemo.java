package com.zhangyu.concurrency.learn.demo;

import java.util.List;

public class ConcurrencyDemo {

    public static void main(String[] args) {
        List<String> list = null;

        for (String str : list) {
            System.out.println(str);
        }
    }
}
