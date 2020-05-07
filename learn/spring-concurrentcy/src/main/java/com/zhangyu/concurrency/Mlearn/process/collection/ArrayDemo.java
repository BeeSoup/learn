package com.zhangyu.concurrency.Mlearn.process.collection;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayDemo {

    public static void main(String[] args) {
        String[] strings = new String[]{"1","2"};
        String[] strings1 = {"11","22"};

        Stream<String> stream = Arrays.stream(strings);
        Stream<String> stream1 = Arrays.stream(strings1);

        stream.forEach(System.out::println);
        stream1.forEach(System.out::println);

//        ArrayList 理论最大Math.Max_Value 最大正整数，然后里面是一个数组

    }
}
