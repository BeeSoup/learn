/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/17  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.openfeign;

import com.zhangyu.service.consumer.configuration.ConsumeFeignClientConfiguration;
import com.zhangyu.service.consumer.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/17
 */
@FeignClient(
        name= "${zhangyu.service.provider}",
        configuration = {
                ConsumeFeignClientConfiguration.class
        }
)
public interface ConsumeFeignClient {


    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/echo/{id}")
    ResponseData<String> findStringById(@PathVariable(value = "id") String id);

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/echo/")
    ResponseData<String> findStringById2(@RequestParam(value = "value") String value);

}

