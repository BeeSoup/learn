package com.zhangyu.concurrency.learn.publish;

import com.sun.javafx.UnmodifiableArrayList;
import com.zhangyu.concurrency.learn.annotation.Unsafe;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 对象移除了，
 * 根据原则应该给与拷贝对象。而不是直接返回这样的对象。
 * 或者是不可修改对象 比如 UnmodifiableArrayList
 */
@Unsafe
public class UnsafePublish {



    String[] str = {"a", "b", "c"};

    public String[] getStr() {
        return str;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.getStr()));

        unsafePublish.getStr()[0] = "d";
        System.out.println(Arrays.toString(unsafePublish.getStr()));
    }
}
