/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/4  zhang  新增
 * ========    =======  ============================================
 */

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/04
 */
@Slf4j
public class MyTest {

//    public static void main(String[] args) {
////        Boolean flag = null;
////        if (flag) {
////            System.out.println("11");
////        }
////        System.out.println("222");
//        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
//        for (URL url : urLs) {
//
//        }
//    }

    /**
     * 2021-01-25 10:36:17.156 INFO  MyTest                                            :34   start
     * 2021-01-25 10:36:17.158 INFO  MyTest                                            :41   invoke
     * 2021-01-25 10:36:17.158 INFO  MyTest                                            :42   return
     * 2021-01-25 10:36:17.158 INFO  MyTest                                            :47   finally
     * 2021-01-25 10:36:17.158 INFO  MyTest                                            :36   end
     *
     * @param args
     */
//    public static void main(String[] args) {
//        log.info("start");
//        testTry();
//        log.info("end");
//    }
//
//    public static void testTry() {
//        try {
//            log.info("invoke");
//            int i = 1/0;
//            log.info("return");
//            return;
//        } catch (Exception e) {
//            Exception ex = new Exception();
//            ex.initCause(e);
//            log.info("catch");
//            return;
//        } finally {
//            log.info("finally");
//        }
//    }
    public static void main(String[] args) {
        File file = new File("C:/Users/zhangyu30939/Desktop/move.txt");
        String absolutePath = file.getAbsolutePath();
        String fileName = file.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String localPath = absolutePath.substring(0, absolutePath.lastIndexOf(fileName));
        log.info(absolutePath);
        log.info(fileName);
        log.info(localPath);
        log.info(suffix);
    }

}
