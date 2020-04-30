package com.zhangyu.concurrency.Mlearn.process.concurrency;

/**
 * Atomic类
 *    AtomicBoolean
 *    AtomicInteger     & AtomicIntegerArray
 *    AtomicLong        & AtomicLongArray
 *    AtomicReference   & AtomicReferenceArray
 *    AtomicMarkableReference & AtomicStampedReference
 *
 *
 * Adder类 聚合类
 * DoubleAccumulator
 * DoubleAdder
 * LongAccumulator
 * LongAdder
 *
 *
 *  CountDownLatch
 *
 *
 *  Executor
 *  ThreadPoolExecutor
 *
 *  并发集合
 *  CopyOnWrite*
 *      并发特征：
 *          读：无锁（volatile） ,快速（O(1)）
 *          写：同步（synchronized） 、复制（较慢消耗内存）
 *
 *  代码实现：CopyOnWriteList/CopyOnWriteSet
 *
 *
 *  ConcurrentSkipList* 实现
 *    并发特性：无锁
 *    数据结构：有序（ConcurrentNavigableMap实现）、跳跃链表（Skip List） 变种
 *    时间复杂度： 平均（N）-containKey/get/put/remove
 *    代表实现：ConcurrentSkipListMap、ConcurrentSkipLiseSet(底层实现ConcurrentSkipListMap)
 *    特征：空间换时间
 */
public class AtomicDemo {
}
