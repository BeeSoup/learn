/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/7/13  zhang  新增
 * ========    =======  ============================================
 */

package defaultdemo;


@FunctionalInterface
public interface MyFunction {


    default String getFunction(String name, String age) {
        return "yes";
    }
    String getFunction(String name);
}

