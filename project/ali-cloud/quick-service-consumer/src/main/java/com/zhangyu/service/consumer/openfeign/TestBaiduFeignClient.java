/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/17  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.openfeign;

import com.zhangyu.service.consumer.sentinel.FeignFallbackFactorySentinel;
import com.zhangyu.service.consumer.sentinel.FeignFallbackSentinel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/17
 */
@FeignClient(
        name = "baidu",
        url = "http://www.baidu.com",
//        fallback = FeignFallbackSentinel.class, 二选一
        fallbackFactory = FeignFallbackFactorySentinel.class
)
public interface TestBaiduFeignClient {

    @GetMapping("")
    String index();
}

