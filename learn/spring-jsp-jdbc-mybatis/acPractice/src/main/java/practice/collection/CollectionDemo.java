package practice.collection;

import java.util.HashMap;
import java.util.Map;

public class CollectionDemo {


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();


        map.put(null, new Object());


        System.out.println(map.get(null));
    }
}
