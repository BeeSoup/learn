package practice.hashcode;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * 说明以及结果， HashMap的key根据hashCode来保证唯一
 * Object hashCode获取物理地址，Integer重写了方法，默认获取值，而String也重写了
 * HashCodeDemo 单纯只复写equals 或者hashCode 还是3 只有同时复写两个才是1
 * IdentityHashMap key 物理地址IdentityHashMap允许key和value都为null。该类不是线程安全的，如果要使之线程安全，可以调用Collections.synchronizedMap(new IdentityHashMap(…))方法来实现。
 * <p>
 * IdentityHashMap重写了equals和hashcode方法，不过需要注意的是hashCode方法并不是借助Object的hashCode来实现的，而是通过System.identityHashCode方法来实现的。
 * <p>
 * HashTable key value 不允许为null cache 也不允许为null 同步
 * HashMap value 可以为null 但是key 不能为null
 */
public class HashCodeTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("a", "2");
        map.put("a", "3");
        System.out.println(map.size()); //1

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(new String("a"), "1");
        hashMap.put(new String("a"), "2");
        hashMap.put(new String("a"), "3");
        System.out.println(hashMap.size()); //1

        Map<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(new Integer(200), "1");
        hashMap2.put(new Integer(200), "2");
        hashMap2.put(new Integer(200), "3");
        System.out.println(hashMap2.size()); //1

        Map<HashCodeDemo, String> hashMap3 = new HashMap<>();
        hashMap3.put(new HashCodeDemo(1), "1");
        hashMap3.put(new HashCodeDemo(1), "2");
        hashMap3.put(new HashCodeDemo(1), "3");
        System.out.println(hashMap3.size()); //3


        //IdentityHashMap使用===================================
        Map<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new String("a"), "1");
        identityHashMap.put(new String("a"), "2");
        identityHashMap.put(new String("a"), "3");
        System.out.println(identityHashMap.size()); //3

        Map<HashCodeDemo, String> identityHashMap2 = new IdentityHashMap<>();
        identityHashMap2.put(new HashCodeDemo(1), "1");
        identityHashMap2.put(new HashCodeDemo(1), "2");
        identityHashMap2.put(new HashCodeDemo(1), "3");
        System.out.println(identityHashMap2.size()); //3

        System.out.println(identityHashMap.get("a")); //null
        System.out.println(identityHashMap2.get(new HashCodeDemo(1))); //null


        HashCodeDemo demo1 = new HashCodeDemo(1);
        HashCodeDemo demo2 = new HashCodeDemo(1);
        Identity identity = new Identity();
        Identity identity2 = new Identity();
        Map<HashCodeDemo, String> ideCode = new IdentityHashMap<>();
        Map<Identity, String> ideMap = new IdentityHashMap<>();
        Map<String, String> strMap = new IdentityHashMap<>();
        ideCode.put(demo1, "demo1");
        ideCode.put(demo2, "demo2");
        ideCode.put(demo2, "demo3");
        ideMap.put(identity, "identity");
        strMap.put("1234", "identity2");
        strMap.put("1234", "identity3");
        strMap.put(new String("1234"), "identity4");
        System.out.println(ideCode.get(demo1)); //demo1
        System.out.println(ideCode.get(demo2)); //demo3
        System.out.println(ideCode.size()); //2
        System.out.println(ideMap.get(identity)); //identity
        System.out.println(strMap.get("1234")); //identity3

    }
}
