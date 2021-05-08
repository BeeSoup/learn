/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/5/7  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * TransmittableThreadLocal WeakHashMap 弱引用
 * 强引用 ---> 内存不足将抛错误
 * 软引用 ---> 优先触发system.gc();
 * 弱引用 ---> 存在于gc的回收链上，弱引用链，先标记，2次回收，
 * 虚引用
 * 功能说明: 线程并发配置 InheritableThreadLocal 允许线程之间的数据共享 仅限于父线程创建的， 或者是匿名内置类
 * 但线程池，不包含在这其中
 */
@Slf4j
public class HelloWorldThreadDemo {

    static InheritableThreadLocal<MyThreadLocal> inheritableThreadLocal = new InheritableThreadLocal<>();
    static ThreadLocal<MyThreadLocal> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        MyThreadLocal myThreadLocal = new MyThreadLocal();
        myThreadLocal.setName("myName");

        // 对象地址
        log.info(System.identityHashCode(myThreadLocal) + "");
        inheritableThreadLocal.set(myThreadLocal);
        threadLocal.set(myThreadLocal);
        Thread t1 = new Thread(HelloWorldThreadDemo::helloWorld);
        t1.start();
        log.info("start");
        // 等待线程结束
        t1.join();
//        t1.join(1000);
        log.info("OK!");
        log.info("main:{}", inheritableThreadLocal.get().getName());
        threadLocal.remove();
        inheritableThreadLocal.remove();
    }

    static void helloWorld() {
        System.out.println("Hello World!");
        MyThreadLocal myThreadLocal = inheritableThreadLocal.get();
        MyThreadLocal myThreadLocal1 = threadLocal.get();
        if (Objects.isNull(myThreadLocal)) {
            log.info("myThreadLocal:{}", "null");
        } else {
            log.info("myThreadLocal.name:{}", myThreadLocal.getName());
            log.info("myThreadLocalIdentity:{}", System.identityHashCode(myThreadLocal) + "");
            myThreadLocal.setName("helloWorldName");
        }

        if (Objects.isNull(myThreadLocal1)) {
            log.info("myThreadLocal1:{}", "null");
        } else {
            log.info("myThreadLocal1.name:{}", myThreadLocal1.getName());
            log.info("myThreadLocal1Identity:{}", System.identityHashCode(myThreadLocal1) + "");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("end");
    }

    @Data
    public static class MyThreadLocal {
        private String name;
    }
}
