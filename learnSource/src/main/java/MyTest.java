/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/4  zhang  新增
 * ========    =======  ============================================
 */

import sun.misc.Launcher;

import java.net.URL;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/04
 */
public class MyTest {

    public static void main(String[] args) {
//        Boolean flag = null;
//        if (flag) {
//            System.out.println("11");
//        }
//        System.out.println("222");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {

        }
    }
}
