/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/10/19  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 功能说明:
 * org.springframework.cloud.gateway.handler.RoutePredicateHandlerMapping
 * org.springframework.cloud.gateway.handler.FilteringWebHandler
 * <p>
 * 断点打在 org.springframework.cloud.gateway.filter.NettyRoutingFilter#filter ，就可以调试Gateway转发的具体细节了。
 * 作者：大目
 * 链接：https://www.imooc.com/article/290816
 * 来源：慕课网
 * 本文原创发布于慕课网 ，转载请注明出处，谢谢合作
 * <p>
 * 认证和授权
 *
 * @author zhang
 * @Date 2020/10/19
 */
@SpringBootApplication
@Slf4j
public class GatewayApplication {

    @Value("${server.port2:2020}")
    private String obj;

    @Bean
    public String obj() {
        return obj;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewayApplication.class, args);

        ConfigurableEnvironment environment = context.getEnvironment();

        log.info("网关:\t 地址：http://127.0.0.1:{}", environment.getProperty("server.port"));
        log.info("网关:\t 地址：http://127.0.0.1:{},{}", environment.getProperty("server.port2"),context.getBean("obj"));
    }
}
