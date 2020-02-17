package com.zhangyu.concurrency.learn.atomic;

/**
 * CAS 的 ABA问题
 *
 * 增加一个Stamp 也就是版本号的概念
 * A为第一版本，B为第二版本 A又为第三版本，这样就不会与设计思想不符合，即每次修改都应该去通知其他线程，该变量是无效的。
 *
 *
 * AtomicLongArray 是一个AtomicLong的数组，也就是除了给与某一个更新值，还需给与一个索引，通过索引更新部分值
 */
public class AtomicStampReferenceDemo {


}
