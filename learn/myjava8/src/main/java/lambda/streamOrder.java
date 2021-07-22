/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/6/29  zhangyu30939  新增
 * ========    =======  ============================================
 */
package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 功能说明:
 *
 *
 * @author zhangyu30939
 * @since 2021-06-29
 */
public class streamOrder {


    public static void main(String[] args) {

        List<MyOrderTest> list =
                // new ArrayList<>();
                Arrays.asList(
                        new MyOrderTest("15", "a", "1"),
                        new MyOrderTest(null, "a", "1"),
                        new MyOrderTest("25", "a", "1"),
                        new MyOrderTest("25", "a", "2"),
                        new MyOrderTest("5", "b", "1"),
                        new MyOrderTest("6", "b", "1"),
                        new MyOrderTest("30", "c", "1"),
                        new MyOrderTest("20", "c", "1"),
                        new MyOrderTest("1", "d", "1"),
                        new MyOrderTest("10", "d", "1"),
                        new MyOrderTest("45", "e", "1"),
                        new MyOrderTest("15", "e", "1"),
                        new MyOrderTest("47", "f", "1"),
                        new MyOrderTest("7", "f", "1")
                );
        // LocalDate localDate = LocalDate.now();
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // for (int i = 0; i < 100000; i++) {

        // list.add(new MyOrderTest(formatter.format(localDate.plus(i / 3, ChronoUnit.DAYS)), "f" + i, "1"));
        // list.add(new MyOrderTest(formatter.format(localDate.plus(i / 3, ChronoUnit.DAYS)), "f" + i, "1"));
        // list.add(new MyOrderTest(formatter.format(localDate.plus(i / 4, ChronoUnit.DAYS)), "f" + i / 4, "1"));

        // }
        // Comparator.reverseOrder()
        // Comparison method violates its general contract!
        // MyOrderTest::getAge
        // 哦yes,测试@Data 会不会覆盖----MyOrderTest{age='null', name='a', boy='1'}
        // Exception in thread "main" java.lang.IllegalArgumentException: 参数不得为空
        list.stream().sorted(Comparator.comparing((MyOrderTest entity) ->
                        Integer.valueOf(Optional.ofNullable(entity.getAge()).orElseThrow(
                                () -> {
                                    System.out.println(entity);
                                    return new IllegalArgumentException("参数不得为空");
                                }
                        )), Comparator.reverseOrder()
//                        (s1, s2) -> {
//                    if (Integer.valueOf(s1) <= Integer.valueOf(s2)) {
//                        return 1;
//                    } else {
//                        return -1;
//                    }
//                    Integer integerS1 = Integer.valueOf(s1);
//
//                    Integer integerS2 = Integer.valueOf(s2);
//
//                    return integerS2.compareTo(integerS1);

//                }
        ).thenComparing(MyOrderTest::getName))
//                .skip(1).limit(2)
                .forEach(
                        System.out::println
                );
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class MyOrderTest {
        private String age;
        private String name;
        private String boy;


//        public Integer getAge() {
//            return Integer.valueOf(age);
//        }

        /**
         * 结果是不会覆盖 整挺好
         *
         * @return
         */
        @Override
        public String toString() {
            return "哦yes,测试@Data 会不会覆盖----MyOrderTest{" +
                    "age='" + age + '\'' +
                    ", name='" + name + '\'' +
                    ", boy='" + boy + '\'' +
                    '}';
        }
    }
}