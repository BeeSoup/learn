package practice.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 测试一下 关于数组是否能存放不同长度的类型，
 *            集合能否定义基本数据类型
 */
public class CollectionTest {
    public static void main(String[] args) throws InterruptedException {
        Object[] objects = {"JAVA8", 8, new CollectionTest()};
        Collection collection = new ArrayList();
        collection.add(8);

        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        //转成Object
        Object[] objects1 = list.toArray();
        Iterator<Integer> iterator = list.iterator();
        //Exception in thread "main" java.util.ConcurrentModificationException
        //	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
        //	at java.util.ArrayList$Itr.next(ArrayList.java:859)
        //	at practice.test.CollectionTest.main(CollectionTest.java:39)
        //添加的同时，删除
        Thread thread = new Thread( () -> {
            for (;;) {
                list.add(5);
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("添加 ：" + list.size());
            }
        });
        thread.start();
        //迭代器删除方法
        while(iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            Thread.currentThread().sleep(1000);
            System.out.println("删除 ：" + list.size());
        }

    }
}
