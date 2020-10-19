
package practice.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/07
 */
@Slf4j
public class StringTest {

    private Integer sum = 0;
    private AtomicInteger integer = new AtomicInteger(5);


    public static void main1(String[] args) {
        Integer capacity = 11;
        int i = capacity >> 1;
        log.info(i + "");

        String[] strArray = new String[]{"111", "222", "223"};
        List<String> strings = Arrays.asList(strArray);
        // a.clone()
        String[] objects = (String[]) strings.toArray();

        List<String> strList = new ArrayList<>(strings);
        strList.add("4444");
        int size = strList.size();


        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        strings.toArray(new String[strings.size()]);

        // Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
        //	at practice.test.StringTest.main(StringTest.java:36)
        String strings1[] = (String[]) list.toArray();
    }

    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(127);// -128~127有存在缓存
        list.add(127);
        list.add(12306);
        list.add(12306);
        log.info("" + (list.get(0) == list.get(1)));
        log.info("" + (Objects.equals(list.get(2), list.get(3))));
        String str = " 111  1123 ".trim() + "OK";
        log.info(str);
    }

    /**
     * 内部类的的成员变量设置为final，也就是可以理解为
     * 一个class是一个单独文件，读入内容的内存的时间，关联分配地址是不可变的，也就是堆栈信息是不可变
     */


    public static void main3(String[] args) {
        try {
            throw new Exception("OKOK");

        } catch (RuntimeException e) {
            throw new ValidatorException(e.getMessage(), e);
        } catch (Exception e) {
            throw new ValidatorException(e.getMessage(), e);
        }
    }

    public static void main4(String[] args) {

        User user = null;
        User user1 = new User("ZHANG", 19);
        User user2 = new User("ZZZZ", 20);
        User user3 = Optional.ofNullable(user).orElse(user2);
        User user4 = Optional.ofNullable(user1).orElse(user3);
        log.info(user3.toString());
        log.info(user4.toString());
    }

    @Data // 包含无参数构造
    @AllArgsConstructor
    static class User {
        String name;
        Integer age;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<>(new StringTest().new MyCallable());
        new Thread(task).start();
        Integer integer = task.get();
        log.info(integer.toString());
    }

    class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            for (int i = integer.getAndDecrement(); i > 0; i = integer.getAndDecrement()) {
                Thread.sleep(5 * 1000);
                sum += i;
            }
            return sum;
        }
    }
}
