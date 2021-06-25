/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/6/1  zhangyu30939  新增
 * ========    =======  ============================================
 */
package com.zhangyu.concurrency.Mlearn.process.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-06-01
 */
public class SynchDemo {

    private static final Logger log = LoggerFactory.getLogger(SynchDemo.class);

    public static void main(String[] args) throws InterruptedException {
        Thread t1  = new Thread(SynchDemo::plan);
        Thread t2  = new Thread(SynchDemo::plan2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //15:30:56.890 [Thread-0] INFO com.zhangyu.concurrency.Mlearn.process.concurrency.SynchDemo - plan
        //15:30:56.890 [Thread-1] INFO com.zhangyu.concurrency.Mlearn.process.concurrency.SynchDemo - plan2
    }

    private static void plan() {
        log.info("plan");
    }

    private static void plan2() {
        log.info("plan2");
    }
}
