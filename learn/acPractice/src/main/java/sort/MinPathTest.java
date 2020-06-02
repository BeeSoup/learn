package sort;

import java.util.ArrayList;
import java.util.List;

public class MinPathTest {
    /**
     * 找出所有的路径，然后放入集合，然后求最小值
     */

    public static void main(String[] args) {
        int[][] path = {{1, 5, 7}, {1, 2, 3}, {3, 4, 5}, {7, 9, 3}, {3, 1, 2}, {5, 7, 4}, {4, 6, 9}, {6, 2, 11}, {5, 1, 2}};
        int[][] edges = {{1, 2, 1}, {2, 3, 3}, {1, 3, 100}};
        System.out.printf("最小惩罚值： %d\n", minPath(0, path, 1, 1));
        System.out.printf("最小惩罚值： %d\n", minPath(0, path, 4, 2));
        System.out.printf("最小惩罚值： %d\n", minPath(0, edges, 1, 3));
    }

    /**
     * 创建路径副本，记录，走过的路径， 最终是否能找到终点，如果可以找到，将节点标记 0->1 有效节点，
     * 当前走过的节点需要标记 0->99，防止循环走
     * 每次当前节点走完以后，都需要清理开始为当前节点的路径标记 99->0
     * 以递归的形式，寻找所有可能的节点。
     * 最后获取是否有效节点下的最小值
     */
    static int minPath(int n, int[][] edges, int start, int end) {
        int[] edgesCopy = new int[edges.length]; // 做一个镜像判断副本，0:初始值 ; 1：走过，有效节点; 99: 走过，未知节点 ; -1：走过，无效节点
        boolean isValid = getAllPathValue(edges, start, end, edgesCopy, 0);
        if (!isValid) {
            return -1;
        }
        int minValue = Integer.MAX_VALUE;
        for (int o = 0; o < edgesCopy.length; o++) { //对于走过的节点，做一个未知清除
            if (edgesCopy[o] == 1) {
                if (minValue > edges[o][2]) {
                    minValue = edges[o][2];
                }
            }
        }
        return minValue;
    }


    //int[][] path = {{1, 5, 7}, {1, 2, 3}, {2, 4, 5}, {7, 9, 8}, {3, 1, 2}, {5, 7, 9}, {4, 6, 9}, {6, 2, 11}, {5, 1, 2}};
    private static boolean getAllPathValue(int[][] edges, int start, int end, int[] copy, int pathSeq) {
        pathSeq = pathSeq + 1;//值传递
        for (int i = 0; i < edges.length; i++) {
            int EStart = edges[i][0];
            int EEnd = edges[i][1];
            String status = "";
            if (copy[i] == 99) {
                status = "走过未知";
            } else if (copy[i] == 0) {
                status = "未走过";
            } else if (copy[i] == 1) {
                status = "有效节点";
            }
            //System.out.printf("目前函数start : %d, end: %d,目前start : %d, end: %d, 节点状态：%s\n", start, end, EStart, EEnd, status);
            if (copy[i] == 99) { //走过 未知
                continue;
            }
            if (edges[i][0] == start) {
                if (copy[i] == 1) {// 对于下一个节点就是有效节点情况，直接返回有效节点， 无需重复走
                    return true;
                }
                if (edges[i][1] == end) {
                    copy[i] = 1; //有效节点
                    //System.out.printf("路径第%d条，其中开始 start : %d, 结束 end: %d\n", pathSeq, start, end);
                    return true;
                } else {
                    copy[i] = 99;
                    boolean lastNode = getAllPathValue(edges, edges[i][1], end, copy, pathSeq);
                    if (lastNode) { //上一个节点是有效节点，那么当前节点也是有效节点
                        copy[i] = 1;
                    }
                    for (int j = 0; j < edges.length; j++) { //对于走过的节点，做一个未知清除
                        if (edges[j][0] == edges[i][1]) {
                            if (copy[j] == 99) {
                                copy[j] = 0;
                            }
                        }
                    }
                }
            }
        }
        for (int j = 0; j < edges.length; j++) { //上一个节点有存在有效节点，当前节点也是有效节点
            if (edges[j][0] == start) {
                if (copy[j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
