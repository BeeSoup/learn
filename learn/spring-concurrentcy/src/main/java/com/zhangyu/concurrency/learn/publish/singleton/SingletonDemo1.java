package com.zhangyu.concurrency.learn.publish.singleton;

import com.zhangyu.concurrency.learn.annotation.SafeThread;
import com.zhangyu.concurrency.learn.annotation.UnsafeThread;

/**
 * 懒汉模式
 * 双重检测锁
 */
@SafeThread
public class SingletonDemo1 {

    // 说明一下 static 修饰的方法和代码块，按顺序执行

    /**
     * 私有化构造函数
     */
    private SingletonDemo1() {

    }

//    new SingletonDemo1();
//    1 、 memory = allocate()  分配对象的内存空间
//    2、 ctorInstance 对象初始化
//    3、instance = memory 设置instance指向对象的内存


    // JVM 和CPU 发生指令重排的情况
    //    new SingletonDemo1();
//    1 、 memory = allocate()  分配对象的内存空间
//    3、instance = memory 设置instance指向对象的内存
//    2、 ctorInstance 对象初始化


    /**
     * 单例的对象
     */
    private volatile static SingletonDemo1 instance = null;

    /**
     * 静态工厂方法
     */
    public static SingletonDemo1 getInstance() {

        if (instance == null) { //B
            synchronized (SingletonDemo1.class) {
                if (instance == null) {
                    instance = new SingletonDemo1(); // A-3
                }
            }
        }

        return instance;
    }


}
