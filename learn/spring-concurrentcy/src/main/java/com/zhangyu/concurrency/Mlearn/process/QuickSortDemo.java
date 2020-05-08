package com.zhangyu.concurrency.Mlearn.process;

import java.util.Arrays;

public class QuickSortDemo {

    public static void main(String[] args) {
        int[] source = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(source));
        quickSort(source, 0, source.length - 1);
        System.out.println(Arrays.toString(source));
    }


    /**
     * 选择一个基准点，从右往左到小于基准，从左往右找大于基准 然后交换直到中间
     * 然后递归
     * 6  1  2 7  9  3  4  5 10  8
     */

    public static void quickSort(int[] target, int left, int right) {
        //递归必须有出口
        if (left > right) {
            return;
        }
        int pivot = target[left];
        int i = left;
        int j = right;
        int temp;
        for (; i < j; ) { //找到中心点 也就是3的 位置完成
            for (; target[j] >= pivot && i < j; j--) ;
            for (; target[i] <= pivot && i < j; i++) ;
            if (i < j) {
                temp = target[i];
                target[i] = target[j];
                target[j] = temp;
            }
        }
        temp = target[left];
        target[left] = target[j];
        target[j] = temp;
        quickSort(target, left, j - 1);
        quickSort(target, j + 1, right);

    }


}
