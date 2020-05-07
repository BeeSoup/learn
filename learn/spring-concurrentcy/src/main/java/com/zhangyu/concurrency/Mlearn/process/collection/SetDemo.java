package com.zhangyu.concurrency.Mlearn.process.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        //无序，但是使用了HashCode 排序，
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("v");
        set.add("c");
        set.forEach(System.out::println);
        set.clear();

        set.add("a1");
        set.add("a3");
        set.add("b1");

        set.forEach(System.out::println);
        //a
        //c
        //v
        //a1
        //a3
        //b1

        Data data1 = new Data(9, "data1");
        Data data2 = new Data(9, "data2");
        Data data3 = new Data(11, "data3");
        Data data4 = new Data(10, "data4");

        //返回0 去重 比较也不是全部比较，只要比较最前一个，
        SortedSet<Data> sortedSet = new TreeSet<>((x, y) -> {
            System.out.printf("x.name = %s, y.name = %s\n", x.getName(), y.getName());
            if (x.getAge() < y.getAge()) {
                return -1;
            } else if (x.getAge() == y.getAge()) {
                return 1;
            } else {
                return 1;
            }
        });

        sortedSet.add(data1);
        sortedSet.add(data2);
        sortedSet.add(data3);
        sortedSet.add(data4);
        sortedSet.forEach(System.out::println);
        // if (x.getAge() > y.getAge()) {
        //                return -1;
        //            } else if (x.getAge() == y.getAge()) {
        //                return 0;
        //            } else {
        //                return 1;
        //            }
        //Data{age=11}
        //Data{age=9}

        // if (x.getAge() > y.getAge()) {
        //                return 0;
        //            } else if (x.getAge() == y.getAge()) {
        //                return 0;
        //            } else {
        //                return 0;
        //            }

        //Data{age=9}

        // if (x.getAge() > y.getAge()) {
        //                return -1;
        //            } else if (x.getAge() == y.getAge()) {
        //                return 1;
        //            } else {
        //                return 1;
        //            }
        //Data{age=11}
        //Data{age=9}
        //Data{age=9}
        //            if (x.getAge() < y.getAge()) {
        //                return -1;
        //            } else if (x.getAge() == y.getAge()) {
        //                return 1;
        //            } else {
        //                return 1;
        //            }
        //Data{age=9, name='data1'}
        //Data{age=9, name='data2'}
        //Data{age=11, name='data3'}

        //

    }

    static class Data {

        public Data(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        private Integer age;

        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
