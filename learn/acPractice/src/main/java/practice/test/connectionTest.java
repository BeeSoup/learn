/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/4/16  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.test;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-04-16
 */
public class connectionTest {

    public static void main(String[] args) {
        test();

    }


    public static int test() {

        try {
            return 1;
        } finally {
            System.out.println("yes");
        }

    }
}
