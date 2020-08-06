/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/6  zhang  新增
 * ========    =======  ============================================
 */

package practice.jvm;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/06
 */
@Slf4j
public class MyClassloader {

    //09:43:39.265 [main] INFO practice.jvm.MyClassloader - 绝对路径 ：/D:/Program%20Files/Java/jdk1.8.0_161/jre/lib/resources.jar
    //
    //09:43:39.269 [main] INFO practice.jvm.MyClassloader - 绝对路径 ：/D:/Program%20Files/Java/jdk1.8.0_161/jre/lib/rt.jar
    //
    //09:43:39.269 [main] INFO practice.jvm.MyClassloader - 绝对路径 ：/D:/Program%20Files/Java/jdk1.8.0_161/jre/lib/sunrsasign.jar
    //
    //09:43:39.269 [main] INFO practice.jvm.MyClassloader - 绝对路径 ：/D:/Program%20Files/Java/jdk1.8.0_161/jre/lib/jsse.jar
    //
    //09:43:39.269 [main] INFO practice.jvm.MyClassloader - 绝对路径 ：/D:/Program%20Files/Java/jdk1.8.0_161/jre/lib/jce.jar
    //
    //09:43:39.269 [main] INFO practice.jvm.MyClassloader - 绝对路径 ：/D:/Program%20Files/Java/jdk1.8.0_161/jre/lib/charsets.jar
    //
    //09:43:39.269 [main] INFO practice.jvm.MyClassloader - 绝对路径 ：/D:/Program%20Files/Java/jdk1.8.0_161/jre/lib/jfr.jar
    //
    //09:43:39.269 [main] INFO practice.jvm.MyClassloader - 绝对路径 ：/D:/Program%20Files/Java/jdk1.8.0_161/jre/classes
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            log.info("Bootstrap绝对路径 ：{}\r\n", url.getPath());
        }
//        URLClassLoader systemClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();//App
//
//        URL[] systemUrl = systemClassLoader.getURLs();
//
//        for (URL url : systemUrl) {
//            log.info("system绝对路径 ：{}\r\n", url.getPath());
//        }

//        // not enough space for object heap
//        URL[] extensionUrl = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();;// extensionClassLoader
//
//       // URL[] extensionUrl = extensionClassLoader.getURLs();
//
//        for (URL url : extensionUrl) {
//            log.info("extension绝对路径 ：{}\r\n", url.getPath());
//        }


//        URL[] urls = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();
//        for (URL url : urls) {
//            System.out.println(url);
//        }
    }
}
