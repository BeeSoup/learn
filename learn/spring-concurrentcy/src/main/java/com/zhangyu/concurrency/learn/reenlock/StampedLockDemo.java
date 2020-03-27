package com.zhangyu.concurrency.learn.reenlock;

import java.util.concurrent.locks.StampedLock;

/**
 * 写、读、客观读
 * <p>
 * 版本和模式 锁返回一个票据也就是数字stamp用
 * 0没有写锁
 */


public class StampedLockDemo {
    class Point {
        private double x, y;
        private final StampedLock sl = new StampedLock();

        void move(double deltaX, double deltaY) { // an exclusively locked method
            long stamp = sl.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                sl.unlockWrite(stamp);
            }
        }

        //下面看看乐观锁案例
        double distanceFromOrigin() { // A read-only method
            long stamp = sl.tryOptimisticRead();//获得一个乐观读锁
            double currentX = x, currentY = y;//将两个字段读入本地局部变量
            if (!sl.validate(stamp)) {// 检查发出乐观读锁后同时是否其他的写锁发生
                stamp = sl.readLock();//如果没有,再一次获得一个读悲观锁
                try {
                    currentX = x; //
                    currentY = y;
                } finally {
                    sl.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

        //下面是悲观锁读取案例
        void moveIfAtOrigin(double newX, double newY) { // upgrade
            // Could instead start with optimistic, not read mode
            long stamp = sl.readLock();
            try {
                while (x == 0.0 && y == 0.0) { //循环，检查当前状态是否符合
                    long ws = sl.tryConvertToWriteLock(stamp);//将读锁转化为写锁
                    if (ws != 0L) { //确认转化是否成功
                        stamp = ws; //如果成功替换票据
                        x = newX;
                        y = newY;
                        break;
                    } else { //如果不能成功转化
                        sl.unlockRead(stamp);//显式释放读锁
                        stamp = sl.writeLock(); //显式直接进行写锁，重试
                    }
                }
            } finally {
                sl.unlock(stamp);
            }
        }
    }
}

