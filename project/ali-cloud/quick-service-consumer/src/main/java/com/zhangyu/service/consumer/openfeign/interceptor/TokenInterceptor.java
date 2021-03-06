/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/10/27  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.openfeign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/10/27
 */
public class TokenInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        // 1、获取token
        // 2、传递token
    }
}
