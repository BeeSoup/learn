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
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 功能说明:
 *      可以拿到异常信息---在限流很降级的时候
 *
 * @author zhang
 * @Date 2020/08/19
 */
@Component
@Slf4j
public class FeignFallbackFactorySentinel implements FallbackFactory<TestBaiduFeignClient> {


    @Override
    public TestBaiduFeignClient create(Throwable cause) {
        return new TestBaiduFeignClient() {
            @Override
            public String index() {
                return null;
            }
        };
    }
}
