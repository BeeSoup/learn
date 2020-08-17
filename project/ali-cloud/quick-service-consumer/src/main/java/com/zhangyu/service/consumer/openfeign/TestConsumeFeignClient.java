/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/17  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.openfeign;

import com.zhangyu.service.consumer.entity.ResponseData;
import com.zhangyu.service.consumer.entity.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/17
 */
@FeignClient(
        name = "${zhangyu.service.provider}"
)
public interface TestConsumeFeignClient {

    // @SpringQueryMap 如果实体类，需要配置 get
    @GetMapping(value = "/q")
    ResponseData query(@SpringQueryMap UserDTO userDTO);


    // 这里不加@RequestBody 好像也是可以的
    // 容易超时报错 注意超时的配置
    @PostMapping(value = "/q2")
    ResponseData query2(@RequestBody UserDTO userDTO);

    // 如果是Post 使用@RequestBody
}
