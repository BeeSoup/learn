/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/6  zhang  新增
 * ========    =======  ============================================
 */

package practice.jvm;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/06
 */
public class MyJvM {
    static {
        System.out.println("333");
    }
    public MyJvM() {
        System.out.println("111");
    }
}
