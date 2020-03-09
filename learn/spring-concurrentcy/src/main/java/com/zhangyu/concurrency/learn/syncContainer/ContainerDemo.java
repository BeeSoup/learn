package com.zhangyu.concurrency.learn.syncContainer;

import java.util.Iterator;
import java.util.Vector;

/**
 * JAVA提供的同步容器 (单纯的方法是原子性的，多个原子性的操作，不能保证整个的原子性) ：
 *           ArrayList  -> Vector、Stack
 *           HashMap -> HashTable(key/value 都不可为null)
 *           Collections.synchronizedXXX(List/Set/Map)
 */
//
public class ContainerDemo {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        vector.remove(1);
        vector.remove(new Integer(3));
        Iterator<Integer> iterator = vector.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


}
