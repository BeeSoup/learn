package com.zhangyu.concurrency.Mlearn.process.MThread;

public class ThreadSuspendAndResumeDemo {

    public static void main2(String[] args) {
        //thread.suspend() 挂机 thread.resume() 恢复，可以使用在任何区域 sleep 都会出让cpu的资源，不释放锁同步资源
        //object.wait()和 object.notify() 一般使用在synchronized 方法或者块中 wait会释放锁同步资源 notify只是更改线程状态重新让线程参与竞争
        //stop会因为释放锁资源，而导致线程不安全，同时会因为状态的错误而导致
        //通过monitor 控制对象状态，wait和notify回去检查
        //interrupt() 子类调用

        //Thread.join()方法，其实调用的是，Thread的Object.wait()方法

        //JAVA 5+ : Condition await 等待   signal
        Thread t1 = new Thread(ThreadSuspendAndResumeDemo::sayHello);
        t1.setName("T1");
        t1.start();

        Thread t2 = new Thread(ThreadSuspendAndResumeDemo::sayHello);
        t2.setName("T2");
        t2.start();
        Object monitor = ThreadSuspendAndResumeDemo.class;

        //对于监控的monitor对象wait以及notify，即同步（互斥）对象wait以及notify

        synchronized (monitor) {
            // 类似与可重入的情况，多个信号量，多个信息
//            monitor.notify();
//            monitor.notify();

            //获得直接notifyAll()
            monitor.notifyAll();

        }

        //线程【T1】:等待
        //线程【T2】:等待
        //线程【T2】:恢复
        //线程【T1】:恢复

    }


    private static void sayHello() {
        Object monitor = ThreadSuspendAndResumeDemo.class;
        Thread current = Thread.currentThread();
        synchronized (monitor) {
            try {
                System.out.println(String.format("线程【%s】:等待", current.getName()));
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("线程【%s】:恢复", current.getName()));
        }

    }

    private static class Person {
        private final Son son;

        public Person(Son son) {
            this.son = son;
        }

        private static class Son {
            private String name;

            public Son(String name) {
                this.name = name;
            }
        }
    }

    /**
     * 局部变量就一定线程安全吗？
     * 并不是，而是说明，可见的变量下，没有线程可以访问，也就是如果多个线程拥有变量的作用域，那么就可能存在，线程不安全的情况（写！修改！）
     */
    private static void myThreadProperties() throws InterruptedException {
        Person person = new Person(new Person.Son("优秀"));


        // 引用类型如果修改了，也会线程不安全
        Thread thread = new Thread(() -> {
            person.son.name = "cao";
            System.out.println("ko:" + person.son.name);
        });

        thread.start();
        thread.join();
        System.out.println(person.son.name);
    }

    public static void main(String[] args) throws InterruptedException {
        myThreadProperties();

    }
}
