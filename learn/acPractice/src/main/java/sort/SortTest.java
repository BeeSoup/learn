package sort;

public class SortTest {

    /**
     * 给定⼀一个按开始时间从⼩小到⼤大排序的时间区间集合，请将重叠的区间合并。
     * 时 间区间集合⽤用⼀一个⼆二维数组表示，⼆二维数组的每⼀一⾏行行表示⼀一个时间区间(闭区 间)，
     * 其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
     * 例例 1:输⼊入:[ [1, 3], [2, 6], [8, 10], [15, 18] ]
     * 返回: [ [1, 6], [8, 10], [15, 18]]
     * 解释:时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
     * 例例 2:输⼊入:[[1, 4], [4, 5]] 返回:[[1, 5]]
     * 解释:时间区间[1，4] 和 [4，5]重叠了了⼀一个时间点，合并之后为 [1，5] 需要实现的⽅方法原型:int[][] merge(int[][] intervals)
     */
    public static void main(String[] args) {
        int[][] source = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println(source.length);
        System.out.println(source[0][0]);
        System.out.println(source[0][1]);
        int[][] merge = merge(source);
        System.out.println(merge);
    }

    /**
     * 已经排序完成，只需要比较下一个左区间，是否比当前的右区间要大
     * 如果要大，直接将当前的指向调整为下一个即可，出口是最后一个区间。
     */
    static int[][] merge(int[][] intervals) {
        int rank = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < intervals.length; i++) {
            int next = i + 1;
            System.out.printf("right:%d\n", intervals[right][1]);
            if (next < intervals.length && intervals[next][0] > intervals[i][1]) {
                intervals[rank][0] = intervals[left][0];
                intervals[rank][1] = intervals[right][1];
                System.out.printf("left:%d, right:%d\n", intervals[left][0], intervals[right][1]);
                left = next;
                rank++;
            } else if (next == intervals.length) {
                intervals[rank][0] = intervals[left][0];
                intervals[rank][1] = intervals[right][1];
                System.out.printf("left:%d, right:%d\n", intervals[left][0], intervals[right][1]);
                rank++;
            }
            right = next;
        }
        int[][] target = new int[rank][2];
        System.arraycopy(intervals, 0, target, 0, rank);
        return target;
    }
}
