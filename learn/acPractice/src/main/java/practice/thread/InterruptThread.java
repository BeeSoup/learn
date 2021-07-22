/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/6/30  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-06-30
 */
@Slf4j
public class InterruptThread {


    private static boolean shareFlag = true;

    private static boolean isShareFlag = true;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (isShareFlag) {
                log.info("t1=================");
            }
            log.info("t1 gogo");
            // 清除
            if (Thread.interrupted()) {
                log.info("t1");
            }
            log.info("t1 end");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (!t1.isInterrupted()) {
                if (shareFlag) {
                    log.info("t1 start:{}", t1.isInterrupted());
                } else {
                    break;
                }
            }
            log.info("t2 -> end");
            isShareFlag = false;
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            log.info("t3 go");
            t1.interrupt();
            log.info("t3 interrupt:{}", t1.isInterrupted());
            t1.interrupt();
            shareFlag = false;
        });
        t3.start();

        t2.join();
    }
}
