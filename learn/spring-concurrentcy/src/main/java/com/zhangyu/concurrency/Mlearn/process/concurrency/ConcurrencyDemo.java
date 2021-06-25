package com.zhangyu.concurrency.Mlearn.process.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 并发安全手段：
 * 可重入Re-entrant  -----对线程而言可以进入synchronized 多少次 进入一下，然后加1
 * 不可变对象
 * 互斥 锁  ---资源饥饿
 * 原子操作
 * 同步 ---死锁，饥饿、优先级倒转、繁忙等待
 * ===信号量、屏障、互斥、条件变量
 * --自旋、读/写锁
 * <p>
 * <p>
 * JAVA 同步原语：
 * synchronized:
 * 锁定对象：对象（Object）和类（Class）  所有的Class对象都是Object的实例，Object object = Object.class
 * 修饰范围：方法（Method）锁定(每个类实例对应一把锁 ,比如A调用了，那么就是A取锁) 注意，对于静态方法来说，那么就是对象锁 和代码块（Block）
 * 特定： 可重入（Reentrant）
 * 实现：Thin Lock /Inflated/HeavyWeight
 * <p>
 * 方法的Flags ACC_SYNCHRONIZED
 * <p>
 * 偏向锁，如果第一个锁住一直执行，没有第二个线程打扰，那么就不执行同步原语 ---单线程的情况
 * （比如CAS的轻量级锁的操作，位代替互斥操作）
 * 在JAVA6的时候是默认开启的 所有在默认多线程访问同步操作的时候，其实是有消耗资源的---消除偏向锁
 * 在你非常熟悉自己的代码前提下，大可禁用偏向锁 -XX:-UseBiasedLocking 。
 * <p>
 * 仅单第一次获取锁的时候，CSA然后将线程ID设置在头里   在synchronized 块里是单线程操作，也就是说 竞争不激烈，线程数小于等于核心数，每个核心处理一个线程
 * <p>
 * acquire release
 * <p>
 * volatile :
 * 底层: 内存屏障
 * 可见性
 * CAS ：比较交换
 * ：原子指令操作
 * <p>
 * 死 锁 ：相互等待
 * 饥 饿 ：线程不执行，忙不过来，比如gc的finalize方法，应该会被GC锁调，但是不一定
 * <p>
 * Future会让线程串行化
 */

public class ConcurrencyDemo {

    private static final Logger log = LoggerFactory.getLogger(ConcurrencyDemo.class);

    /**
     * public class Lock{
     * boolean isLocked = false;
     * Thread  lockedBy = null;
     * int lockedCount = 0;
     * public synchronized void lock()
     * throws InterruptedException{
     * Thread thread = Thread.currentThread();
     * while(isLocked && lockedBy != thread){
     * wait();
     * }
     * isLocked = true;
     * lockedCount++;
     * lockedBy = thread;
     * }
     * public synchronized void unlock(){
     * if(Thread.currentThread() == this.lockedBy){
     * lockedCount--;
     * if(lockedCount == 0){
     * isLocked = false;
     * notify();
     * }
     * }
     * }
     * }
     * 重可入，表示，假设锁定的是同一个对象，当线程持有这个对象的时候，再获取到这个对象的锁，无需解锁，在加锁，这种操作，而是直接的以加1的形式。注意：同一个对象的重进入
     * 不可重入，也就是线程持有对象，再判断这个锁的对象的时候，必须解锁，然后在获取到锁，死锁，如果解锁，也有风险，也就是自旋
     *
     * @param args
     */

    public static void main(String[] args) {


        log.info("start");

        Thread thread = new Thread(
                () -> {
                    synchronized (ConcurrencyDemo.class) {
                        try {
                            Thread.sleep(50000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ConcurrencyDemo.sync();
                    }
                }
        );

        /**
         * monitor ConcurrencyDemo.class
         */
        synchronized (ConcurrencyDemo.class) {

        }


    }

    /**
     * monitor（）
     */
    public synchronized static void sync() {
        try {
            log.info("static");
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method() {
        log.info("method");
    }


}
