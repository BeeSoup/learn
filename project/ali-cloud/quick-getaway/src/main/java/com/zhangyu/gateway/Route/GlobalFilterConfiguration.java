/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/10/21  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.gateway.Route;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/10/21
 */
@Configuration
@Slf4j
public class GlobalFilterConfiguration {

//    @Bean
//    @Order(-1)
//    public GlobalFilter globalFilter1() {
//        return (exchange, chain) -> {
//            log.info("开始");
//            chain.filter(exchange).then()
//        };
//    }

}
