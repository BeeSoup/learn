package com.zhangyu.concurrency.Mlearn.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.Date;

public class RuntimeXb {
    public static void main(String[] args) {

        //获取当前进程的ID
        getProcessId();

        //进程启动时间，UpTime是在线时间
        getProcessStartTime();

        //获取线程数量
        getProcessThreadCount();

        //2036@zhangyudeMacBook-Pro.local
        //2036
        //进程启动时间: Mon Apr 20 14:59:11 CST 2020
        //线程数量5


        getProcessMemoryInfo();
    }

    private static void getProcessMemoryInfo() {
        ManagementFactory.getMemoryManagerMXBeans().forEach(memoryManagerMXBean -> {

        });
    }

    private static void getProcessThreadCount() {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        int threadCount = threadMXBean.getThreadCount();
        System.out.println("线程数量" + threadCount);


    }

    private static void getProcessStartTime() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long time = runtimeMXBean.getStartTime();
//        进程启动时间: 1587365441256
        System.out.printf("进程启动时间: %s\n", new Date(time));
    }

    private static void getProcessId() {

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String name = runtimeMXBean.getName();
        //1752@zhangyudeMacBook-Pro.local   进程ID
        System.out.println(name);

        //进程pId
        System.out.println(name.substring(0, name.indexOf("@")));

    }
}
