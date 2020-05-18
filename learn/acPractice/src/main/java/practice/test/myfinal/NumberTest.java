package practice.test.myfinal;

import practice.test.ChildA1;
import practice.test.ChildA2;
import practice.test.ParantA;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class NumberTest {

    public static void main(String[] args) throws Exception {

        final Unsafe unsafe = getUnsafe();

        int a = 1;
        int b = 1;
        int c = 1111111;
        int d = 1111111;
        int e = new Integer(1);
        int f = new Integer(1111111);
        Integer h = 1;
        Integer g = new Integer(1);
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == a);
        System.out.println(d == f);
        test(b);
        System.out.println(b);
        System.out.println(h == g);
        test2(h);
        System.out.println(h);
        //true
        //true
        //true
        //true
        //1
        //false
        //1

        //其实都是指针引用，只不过说，基本数据类型 赋值其实就是一个new 新对象导致的，大致这样理解
        ParantA number = new ChildA1(5);
        System.out.println(number.getNumber());
        test3(number);
        System.out.println(number.getNumber());
        //5
        //5

//        int offset = unsafe.arrayBaseOffset(String.class);//获得基础字符串Base地址
//        int scale = unsafe.arrayIndexScale(String.class);//扫描地址

        //这个其实就能证明，存的是指针引用
        String name = "tom";
        System.out.printf("name of begin: %s，memory : %s\n", name, System.identityHashCode(name));
        test4(name);
        System.out.printf("name of begin: %s，memory : %s\n", name, System.identityHashCode(name));
        //name of begin: tom，memory : 791452441
        //name of test4: Tom，memory : 791452441
        //name of begin: Tom，memory : 791452441


    }

    private static void test4(String name) throws Exception {
        Class clazz = name.getClass();
        //需要使用getDeclaredField(), getField()只能获取公共成员字段
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);

        char[] ch = (char[]) field.get(name);
        ch[0] = 'T';
        System.out.printf("name of test4: %s，memory : %s\n", name, System.identityHashCode(name));
    }

    //final 测试不了 可以通过反射测试。字符串来测试即可
//    private static class MyInteger extends Integer{
//
//        public MyInteger(int value) {
//            super(value);
//        }
//    }

    private static void test3(ParantA number) {
        number = new ChildA2(10);
    }

    public static void test(int test) {
        test = 2;

    }

    public static void test2(Integer integer) {
        integer = 2;
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

}
