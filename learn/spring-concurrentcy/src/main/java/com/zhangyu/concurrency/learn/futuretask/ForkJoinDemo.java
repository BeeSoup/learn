package com.zhangyu.concurrency.learn.futuretask;

import com.zhangyu.concurrency.learn.Util.LogUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * fork/join
 * 大任务进行拆分 汇总
 * 采用，工作窃取算法
 * 双端队列，减少竞争 正常头部，窃取尾部
 * 局限性： 只能用fork和join不能用其他同步手段
 * 2、不能执行IO操作
 * 3、任务不能抛出检查异常
 * ForkJoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    public static final int THRESHOLD = 2;
    private int start;
    private int end;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值就拆分，分裂为两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinDemo leftTask = new ForkJoinDemo(start, middle);
            ForkJoinDemo rightTask = new ForkJoinDemo(middle + 1, end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待执行，并且获取结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            sum = leftResult + rightResult;

        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        //生成一个计算任务，计算1+..+100
        ForkJoinDemo task = new ForkJoinDemo(1, 100);

        //执行任务
        Future<Integer> result = pool.submit(task);

        try {
            LogUtils.log().info("result = {}", result.get());
        } catch (Exception e) {

        }
    }
}
