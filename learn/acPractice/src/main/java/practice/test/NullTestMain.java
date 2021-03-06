/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/4/2  zhang  新增
 * ========    =======  ============================================
 */

package practice.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2021/04/02
 */
public class NullTestMain {

    public static void main(String[] args) {

        List<String> list = null;

        list.forEach(System.out::println);

        for (String s : list) {
            System.out.println(s);
        }

    }
}
