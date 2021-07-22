package lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/11/12 15:20
 */
@Slf4j
public class SSS {
//
//    public static void main(String[] args) {
//
//        String msg = "";
//        Integer.valueOf(msg);
//        log.info("yes");
//
//    }

    public static void main(String[] args) {
        int i = 0;
//        synchronized (i) {
//
//        }

    }

//    public static void main(String[] args) {
//        int length = 10000;
//        List<String> list = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        for (int i = 0; i < length; i++) {
//            list.add("test" + i);
//            list1.add("test" + (length + i));
//        }
//        long st = System.nanoTime();
//        System.out.println(checkDiffrent4(list, list1));
//        System.out.println("消耗时间为4： " + (System.nanoTime() - st));
//
//        st = System.nanoTime();
//        System.out.println(checkDiffrent5(list, list1));
//        System.out.println("消耗时间为5： " + (System.nanoTime() - st));
//
//        st = System.nanoTime();
//        System.out.println(checkDiffrent(list, list1));
//        System.out.println("消耗时间为1： " + (System.nanoTime() - st));
//    }

    /**
     * 方法一：使用循环遍历
     */
    private static boolean checkDiffrent(List<String> list, List<String> list1) {
        for (String sta1 : list1) {
            for (String str : list) {
                if (str.equals(sta1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用stream流去比较两个数组是否相等
     * 方法5
     */
    private static boolean checkDiffrent4(List<String> list, List<String> list1) {
        /** 先将集合转成stream流进行排序然后转成字符串进行比较 */
        return list.stream().sorted().collect(Collectors.joining())
                .equals(list1.stream().sorted().collect(Collectors.joining()));
    }

    /**
     * 使用list自带的sort方法先进性排序，然后转成toString去判断两个集合是否相等
     * 方法6
     */
    private static boolean checkDiffrent5(List<String> list, List<String> list1) {
        list.sort(Comparator.comparing(String::hashCode));
        list1.sort(Comparator.comparing(String::hashCode));
        return list.toString().equals(list1.toString());
    }

}
