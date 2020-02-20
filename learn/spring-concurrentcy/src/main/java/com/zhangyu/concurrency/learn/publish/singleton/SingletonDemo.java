package com.zhangyu.concurrency.learn.publish.singleton;

import com.zhangyu.concurrency.learn.annotation.Unsafe;
import com.zhangyu.concurrency.learn.annotation.UnsafeThread;

/**
 * 懒汉模式
 */
@UnsafeThread
public class SingletonDemo {


    /**
     * 私有化构造函数
     */
    private SingletonDemo() {

    }

    /**
     * 单例的对象
     */
    private static SingletonDemo instance = null;

    /**
     * 静态工厂方法
     */
    public static SingletonDemo getInstance() {

        if (instance == null) {
            instance = new SingletonDemo();
        }

        return instance;
    }


}
