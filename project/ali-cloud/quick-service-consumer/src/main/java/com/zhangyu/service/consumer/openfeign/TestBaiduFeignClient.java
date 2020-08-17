/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/17  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.openfeign;

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
        url = "http://www.baidu.com"
)
public interface TestBaiduFeignClient {

    @GetMapping("")
    String index();
}

