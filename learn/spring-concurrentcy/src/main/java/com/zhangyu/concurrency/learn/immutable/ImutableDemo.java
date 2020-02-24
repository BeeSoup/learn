package com.zhangyu.concurrency.learn.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImutableDemo {

    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "1");
        map.put(2, "2");
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,"3");
        //throw Un
    }
}
