package com.zhangyu.concurrency.Mlearn.process;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU算法的原理比较简单，数据存储的数据结构为链表。当访问数据时，如缓存中有数据，则将该数据移动至链表的顶端；没有该数据则在顶端加入该数据，并移除链表中的低端的数据
 * 在容量未达到限制时
 * -新数据放入顶端
 * -旧数据移到顶端
 * 到达容量时：
 * -末尾数据删除，新数据放入顶端，
 * -旧数据移到顶端
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put("1", 1);
        lruCache.put("1", 1);
        lruCache.put("1", 1);
        lruCache.put("1", 1);
        lruCache.put("2", 2);
        Object o = lruCache.get("1");
        System.out.println(o.toString());
        LinkedHashMap<String, Object> table = lruCache.getTable();
        lruCache.put("3", 3);
        lruCache.put("4", 4);
        o = lruCache.get("1");
        System.out.println(o.toString());
        o = lruCache.get("2");
        System.out.println(o == null ? "null" : o.toString());

    }

    private final LinkedHashMap<String, Object> table;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        this.table = new LinkedHashMap<String, Object>(capacity, 0.75f, true) { //accessOrder ->true get的时候会重排
                                                                                                      //保证访问顺序
            protected boolean removeEldestEntry(Map.Entry eldest) { //复写方法 如果容量大于规定的容量，就移除最古老的，也就是最后一个
                return size() > CAPACITY;
            }
        };
        this.CAPACITY = capacity;
    }

    //获取不到的时候 返回默认的-1 Linked get/getOrDefault 会印象排序
    public Object get(String key) {
//        return table.getOrDefault(key, -1);
        return table.get(key);
    }

    public void put(String key, Object value) {
        table.put(key, value);
    }

    public LinkedHashMap<String, Object> getTable() {
        return table;
    }
}
