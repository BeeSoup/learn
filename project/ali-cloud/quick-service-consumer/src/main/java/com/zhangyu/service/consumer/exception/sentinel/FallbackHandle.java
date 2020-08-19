/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/18  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.exception.sentinel;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/18
 */
@Slf4j
public class FallbackHandle {


    /**
     * 1.6以上，异常会走到这里
     * 处理降级
     *
     * @param a
     * @param e
     * @return
     */
    public String fallback(String a, Throwable e) {
        // 对于保护的资源如果 限流或者降级了
        log.warn("呵呵");
        return "呵呵";
    }
}
