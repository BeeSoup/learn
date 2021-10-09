/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/9  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.proxy;

/**
 * 功能说明: 目标执行接口
 *
 * @author zhangyu30939
 * @since 2021-10-09
 */

public interface Target {

    String execute();

    default String execute2() {
        System.out.println("execute2");
        return "default";
    }
}
