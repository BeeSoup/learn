package com.zhangyu.concurrency.Mlearn.process.collection;


/**
 * 阻塞锁和非阻塞锁 说明：
 *  阻塞锁，就是无法获取到锁，那么就加入阻塞队列，等待已经获取锁的线程释放资源，然后再唤醒竞争
 *  非阻塞锁，就是如果无法获取到锁的情况下，那么就直接返回失败，直接处理。
 */

/**
 * 集合框架总览： 分为两种：
 *   java.util.Collection size()最大值也会返回Integer.MAX_VALUE  toArray 变数组  --可以只读
 *      --java.util.List --坐标访问 可以重复
 *           -Impl --ArrayList
 *                 --LinkedList
 *      --java.util.Set  -- 不允许重复
 *      --java.util.SortedSet --有序的
 *              --java.util.NavigableSet (since JAVA6)
 *                  --TreeSet
 *
 *      --java.util.queue
 *          --java.util.concurrent.BlockingQueue --Since JAVA5
 *          --java.util.concurrent.BlockingDeque --Since JAVA6
 *          --java.util.concurrent.TransferQueue --Since JAVA7
 *
 *
 *              --poll  Retrieves and removes the head of this queue,
 *              --peek Retrieves, but does not remove, the head of this queue,
 *              --offer 接口语义可能发生改变
 *                      --since JAVA5
 *      --java.util.deque
 *              --since JAVA6
 *   java.util.Map或者其他接口
 *      --java.util.SortedMap
 *          Set底层使用了Map的Key的实现
 *      --java.util.NavigableMap --Since JAVA6  Set 相当于 Map<Key(Set),Value(static final Object)>
 *          使用key求HashCode
 *
 *
 *   Dictionary : value['a'] = a 字段模式
 */
public class CollectionFrameworkDemo {

    private static volatile Object obj;

    public static void main(String[] args) {
        if (obj == null) {
            System.out.println("yes");
        }

    }
}
