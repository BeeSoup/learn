package com.zhangyu.concurrency.learn.publish;

import com.zhangyu.concurrency.learn.annotation.Unsafe;

/**
 * 对象溢出，即在对象未完成初始化的时候，
 * 就使其能被其他线程看到
 */
@Unsafe
public class Escape {

    private int isInt = 0;

    public Escape() {

    }


    private class InnerClass {

        public InnerClass() {
            System.out.println(Escape.this.isInt);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
