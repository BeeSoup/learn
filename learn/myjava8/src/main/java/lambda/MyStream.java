package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建： 1、Collection .stream() 串行流 或者是parallelStream 并行流
 * 2、Arrays.  stream()获取数组流
 * 3、通过Stream静态方法 of
 * 4、无限流 Stream.iterate(0, (x) -> x + 2)
 *
 *  filter limit skip distinct
 *  map 应用处理每一个元素，也就是每一个每一个元素都会应用这个函数
 *  flatMap 把流转成成内容，多个流合成一个流
 *
 *  limit  row<n 前， skip 跳过前 row>n  distinct 通过hashCode 和equals 去重
 * @author zhangyu30939
 */
public class MyStream {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        Stream<Integer> integerStream = integers.parallelStream();

        Stream<Integer> stream = integers.stream();
//        Arrays.stream("")
//        Stream.of() //可变参，可以接受数组
        // Stream.iterate(0, (x) -> x + 2); //
        //Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
        //  Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
        int i = 3;
        integerStream.filter((x) -> {
            if (x > i) {
                return true;
            }
            return false;
        }).forEach(System.out::println);
//        Arrays.asList(new Integer[]{111,2222});
    }

//    /**
//     * 使用stream流去比较两个数组是否相等
//     * 方法5
//     */
//    private static boolean checkDiffrent4(List<String> list, List<String> list1) {
//        long st = System.nanoTime();
//        System.out.println("消耗时间为： " + (System.nanoTime() - st));
//        /** 先将集合转成stream流进行排序然后转成字符串进行比较 */
//        return list.stream().sorted().collect(Collectors.joining())
//                .equals(list1.stream().sorted().collect(Collectors.joining()));
//    }

}
