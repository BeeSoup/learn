package com.zhangyu.quick.gateway.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * Spring Cloud Gateway有三个核心概念：路由、断言、过滤器
 * 过滤器：gateway有两种filter：GlobalFilter、GatewayFilter，全局过滤器默认对所有路由有效。
 * 通过过滤器实现统一认证鉴权、日志、安全等检验
 */
@Slf4j
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 9)//配置过滤器等级
public class RequestGlobalFilter2 implements GlobalFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        RequestPath path = request.getPath();
        log.info(String.format("filter: gateway! --RequestGlobalFilter2"));
        return chain.filter(exchange);
    }
}
