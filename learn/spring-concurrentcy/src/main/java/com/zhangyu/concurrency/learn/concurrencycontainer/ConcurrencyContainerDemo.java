package com.zhangyu.concurrency.learn.concurrencycontainer;

/**
 * 线程限制，线程独占 比如ThreadLocal 或者是方法变量 ThreadLocal维护一个线程IdKey,可以存放一些信息，通过过滤器存入，然后在线程中使用
 * 共享只读 如名
 * 线程安全对象 加锁，并发容器等
 * 被守护对象
 *
 *  AQS
 *  并发容器 J.U.C java.util.concurrent
 *  ArrayList -------> CopyOnWriteArrayList   //写操作的时候，复制 加锁了 可能导致JC  add需要时间，实时性不能满足，可能读到
 *                                              旧数据 不建议使用，add操作，全拷贝，影响性能
 *  HashSet/TreeSet---->CopyOnWriteArraySet/ConcurrentSkipListSet ConcurrentSkipListSet支持自然排序自己定义比较器 批量操作不一定是原子性需要自己加锁
 *                                              不允许使用null
 *  HashMap/TreeMap---->ConcurrentHashMap/ConcurrentSkipListMap,不允许null  Skip :key 有序的存取数和并发量无关，所以，
 */
public class ConcurrencyContainerDemo {
}
