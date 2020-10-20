/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/10/19  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.gateway.Route;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 功能说明:
 * 约定，以RoutePredicateFactory结尾
 *
 * @author zhang
 * @Date 2020/10/19
 */
@Component
public class TimeZhangRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeZhangDTO> {

    public TimeZhangRoutePredicateFactory() {
        super(TimeZhangDTO.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TimeZhangDTO config) {
        config.getBefore();
        config.getEnd();
        return serverWebExchange -> {
            return true;
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("before", "end");
    }
}
