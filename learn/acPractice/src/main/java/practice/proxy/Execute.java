/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/9  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-09
 */
@Slf4j
public class Execute implements Target {
    @Override
    public String execute() {
        log.info("执行目标");
        return "success";
    }

    @Override
    public String execute2() {
        log.info("执行目标2");
        return "success";
    }
}
