/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/7/8  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-07-08
 */
public class RegexTest {

    public static void main(String[] args) {
        //
        Pattern pattern = Pattern.compile("[A-Za-z]*");
//        Pattern pattern2 = Pattern.compile("^[\u4e00-\u9fa5]$");
        Pattern pattern2 = Pattern.compile("^[\u4e00-\u9fa5]*$");
        Pattern pattern3 = Pattern.compile("[1-9]*");
        Pattern pattern4 = Pattern.compile("^[1-9]*|[A-Za-z]*|[\u4e00-\u9fa5]*$");
        Matcher matcher1 = pattern.matcher("AAA");
        Matcher matcher2 = pattern2.matcher("汉字");
        Matcher matcher3 = pattern3.matcher("3333");
        Matcher matcher4 = pattern4.matcher("3333汉字AAA");
        System.out.println( matcher1.matches());
        System.out.println( matcher2.matches());
        System.out.println( matcher3.matches());
        System.out.println( matcher4.matches());


    }

}
