package lambda;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 内置接口：
 * Consumer 消费者
 * <p>
 * Supplier 供给型
 * <p>
 * Function 函数型
 * <p>
 * Predicate 断言型
 * <p>
 * 一、方法引用
 * 对象::实例方法   参数列表，返回值要一致
 * 静态::方法       参数列表，返回值要一致
 * 类  :: 方法      对应的引用 = String::equals;  //(x, y) -> x.equals(y); 类::方法
 * <p>
 * 二、 构造器引用
 * ClassName:: new
 * 参数列表一致匹配
 *
 * 三、数组引用
 *  创建一个长度为某某的数组
 * Type[]::new
 */
public class MyLambda {


    public static void main(String args[]) {

//        Consumer<String> com = System.out::println;
        Consumer<String> com
//                = new Consumer<String>(){
//
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
//        = (x) -> System.out.println(x);
                = System.out::println;
        BiPredicate<String, String> bp
                //= String::equals;//(x, y) -> x.equals(y); 类::方法
                = (x, y) -> x.equals(y);
        boolean test = bp.test("1111", "2222");

//        Function<Integer, List<Integer>> fun = (x) -> Arrays.asList(x);
//        Integer[] apply = fun.apply(10);
//        System.out.println(apply);
//            Function<Integer, Integer[]> fun = (x) -> new Integer[] {x};
//        Integer[] apply = fun.apply(10);
//
//        System.out.println(apply[0]);
        Function<Integer, Integer[]> fun = Integer[]::new;
        Integer[] apply = fun.apply(10);

        System.out.println(apply.length);
        System.out.println(apply[0]);
        com.accept(test + "");
        if ("0".equals(null)) {

        } else {
            System.out.println("yes");
        }
    }


    private boolean getPreTradeSericePredicate(Long sysordid, String tradeType, BiPredicate<Long, String> biPredicate) {
        return biPredicate.test(sysordid,tradeType);
    }

}
