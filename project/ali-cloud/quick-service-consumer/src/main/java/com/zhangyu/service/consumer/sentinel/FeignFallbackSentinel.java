/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/19  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.sentinel;

import com.zhangyu.service.consumer.openfeign.TestBaiduFeignClient;
import org.springframework.stereotype.Component;

/**
 * 功能说明:
 *    自定义限流和降级feign-fallBack实现
 *
 * @author zhang
 * @Date 2020/08/19
 */
@Component
public class FeignFallbackSentinel implements TestBaiduFeignClient {

    @Override
    public String index() {
        return "被限流，被降级";
    }
}
