package com.zhangyu.concurrency.Mlearn.process;

import java.util.Arrays;

public class MergeSortDemo {
    /**
     * 拆分到不能再拆，再对每一个排序 每一个分组求排序，顺序排序，走一遍即可
     */

    /**
     * 84571362
     */

    public static void main(String[] args) {

        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] arrCopy = {4, 8};
//        System.arraycopy(arrCopy, 0, arr, 0, arrCopy.length);
//        System.out.println(Arrays.toString(arr));


        System.out.printf("开始： %s\n", Arrays.toString(arr));
        mergeSort(arr);
        //开始： [8, 4, 5, 7, 1, 3, 6, 2]
        //拆分的left : 0,拆分的mid : 0, 拆分的right : 1, 获得的数组： [8, 4]
        //每次分治并且排序后，最终的数组： [4, 8, 5, 7, 1, 3, 6, 2]
        //拆分的left : 2,拆分的mid : 2, 拆分的right : 3, 获得的数组： [5, 7]
        //每次分治并且排序后，最终的数组： [4, 8, 5, 7, 1, 3, 6, 2]
        //拆分的left : 0,拆分的mid : 1, 拆分的right : 3, 获得的数组： [4, 8, 5, 7]
        //temp : [4, 5, 7, 8, 0, 0, 0, 0]
        //每次分治并且排序后，最终的数组： [4, 5, 7, 8, 1, 3, 6, 2]
        //拆分的left : 4,拆分的mid : 4, 拆分的right : 5, 获得的数组： [1, 3]
        //每次分治并且排序后，最终的数组： [4, 5, 7, 8, 1, 3, 6, 2]
        //拆分的left : 6,拆分的mid : 6, 拆分的right : 7, 获得的数组： [6, 2]
        //每次分治并且排序后，最终的数组： [4, 5, 7, 8, 1, 3, 2, 6]
        //拆分的left : 4,拆分的mid : 5, 拆分的right : 7, 获得的数组： [1, 3, 2, 6]
        //temp : [1, 2, 3, 6, 0, 0, 0, 0]
        //每次分治并且排序后，最终的数组： [4, 5, 7, 8, 1, 2, 3, 6]
        //拆分的left : 0,拆分的mid : 3, 拆分的right : 7, 获得的数组： [4, 5, 7, 8, 1, 2, 3, 6]
        //temp : [1, 2, 3, 4, 5, 6, 7, 8]
        //每次分治并且排序后，最终的数组： [1, 2, 3, 4, 5, 6, 7, 8]
    }

    private static void mergeSort(int[] arr) {

        int[] allTemp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, allTemp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] allTemp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, allTemp);
            mergeSort(arr, mid + 1, right, allTemp);
            int[] temp = new int[right - left + 1];
            System.arraycopy(arr, left, temp, 0, right - left + 1);
            System.out.printf("拆分的left : %d,拆分的mid : %d, 拆分的right : %d, 获得的数组： %s\n", left, mid, right,
                    Arrays.toString(temp));
            sort(arr, left, mid, right, allTemp);
            System.out.printf("每次分治并且排序后，最终的数组： %s\n", Arrays.toString(arr));
        }
    }

    private static void sort(int[] arr, int left, int mid, int right, int[] temp) {
        //相邻的，直接排序
        if (right - left < 2) {
            if (arr[right] > arr[left]) {
                return;
            } else {
                int swap = arr[right];
                arr[right] = arr[left];
                arr[left] = swap;
            }
        } else {
            //本身顺序的情况，直接返回
            if (arr[mid] < arr[mid + 1]) {
                return;
            }
            int i = left, j = mid + 1, t = 0;
            for (; t < temp.length && i <= mid && j <= right; ) {
                if (arr[i] <= arr[j]) {
                    temp[t++] = arr[i++];
                } else {
                    temp[t++] = arr[j++];
                }
            }
            for (; i <= mid; ) {
                temp[t++] = arr[i++];
            }
            for (; j <= right; ) {
                temp[t++] = arr[j++];
            }
            System.arraycopy(temp, 0, arr, left, right - left + 1);
            System.out.printf("temp : %s\n", Arrays.toString(temp));
        }
    }


}
