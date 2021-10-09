/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/7/8  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-07-08
 */
@Slf4j
public class RegexTest {

    public static void main(String[] args) {
        //
//        Pattern pattern = Pattern.compile("[A-Za-z]*");
//        // Pattern pattern2 = Pattern.compile("^[\u4e00-\u9fa5]$");
//        Pattern pattern2 = Pattern.compile("^[\u4e00-\u9fa5]*$");
//        Pattern pattern3 = Pattern.compile("[1-9]*");
//        Pattern pattern4 = Pattern.compile("^[1-9]*|[A-Za-z]*|[\u4e00-\u9fa5]*$");
//        Matcher matcher1 = pattern.matcher("AAA");
//        Matcher matcher2 = pattern2.matcher("汉字");
//        Matcher matcher3 = pattern3.matcher("3333");
//        Matcher matcher4 = pattern4.matcher("3333汉字AAA");
//        System.out.println(matcher1.matches());
//        System.out.println(matcher2.matches());
//        System.out.println(matcher3.matches());
//        System.out.println(matcher4.matches());

//        Pattern pattern = Pattern.compile("^\\d\\.*");
//        Matcher matcher1 = pattern.matcher("1.XXX");
//        System.out.println(matcher1.matches());
        String sp = "21X11111";
        Pattern pattern = Pattern.compile("[1-9]*");
        String[] split = Pattern.compile("\\.").split(sp, 2);
        if (split.length == 2 && pattern.matcher(split[0]).matches()) {
            System.out.println("yes");
        }
        System.out.println(Arrays.asList(split));
    }

    public static void main2(String[] args) {

        String charterId = "7-1-2-3-1";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(charterId);
        List<String> charterIdList = new ArrayList<>();
        charterIdList.add(stringBuffer.toString());
        for (int i = stringBuffer.lastIndexOf("-"); i > -1; i = stringBuffer.lastIndexOf("-")) {
            stringBuffer.setLength(i);
            charterIdList.add(stringBuffer.toString());
        }
        System.out.println(charterIdList);
    }

    public static void main5(String[] args) {
        String str = "一";
        String str2 = "十一";

        char[] chars = str.toCharArray();
        char[] chars1 = str2.toCharArray();
        log.info("{}，{}", chars.length, chars1.length);

    }

}
