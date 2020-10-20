/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/10/20  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.gateway.Route;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/10/20
 */
@Component
@Slf4j
public class PreLogGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {


        return (exchange, chain) -> {
            // 这里面才是业务逻辑
            String name = config.getName();
            String value = config.getValue();
            log.info("过滤器测试");
            ServerHttpRequest request = exchange.getRequest()
                    .mutate()
                    .build();
            ServerWebExchange web = exchange.mutate()
                    .request(request)
                    .build();

            return chain.filter(web);
        };
    }
}
