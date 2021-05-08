/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/9/23  zhang  新增
 * ========    =======  ============================================
 */

package practice.test;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * 功能说明: 1 2 = i 3 = j 4 5 5.5 6 7 8 9 10
 *
 * @author zhang
 * @Date 2020/09/23
 */
@Slf4j
public class MyBig {

    public static void main(String[] args) {

//        DateTime dt = DateTime.ParseExact(dateString, "yyyyMMdd", System.Globalization.CultureInfo.CurrentCulture);
        byte[] b = {0x01, 0x01}; // 以两个0x01做分隔符
        String separator = new String(b);
        String str = "1" + separator + "A" + separator + separator;
        String[] split = str.split(separator);
        char c = separator.charAt(0);
        String[] str2 = Pattern.compile(separator).split(str, -1);


        BigDecimal bigDecimal = new BigDecimal(-12.66666666);
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        log.info(decimalFormat.format(bigDecimal));
    }
}
