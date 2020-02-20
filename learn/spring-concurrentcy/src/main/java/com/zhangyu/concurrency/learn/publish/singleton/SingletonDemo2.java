package com.zhangyu.concurrency.learn.publish.singleton;

import com.zhangyu.concurrency.learn.annotation.SafeThread;
import com.zhangyu.concurrency.learn.annotation.UnsafeThread;

/**
 * 枚举单例模式
 * 饿汉模式
 */
@SafeThread
public class SingletonDemo2 {


    /**
     * 私有化构造函数
     */
    private SingletonDemo2() {

    }


    /**
     * 静态工厂方法
     */
    public static SingletonDemo2 getInstance() {
        return instanceEnum.INSTANCE.getInstance();
    }

    private enum instanceEnum {
        INSTANCE;

        private SingletonDemo2 instance = null;

        /**
         * 由JVM保证绝对只执行一次
         */
        private instanceEnum() {
            instance = new SingletonDemo2();
        }

        private SingletonDemo2 getInstance() {
            return instance;
        }
    }


}
