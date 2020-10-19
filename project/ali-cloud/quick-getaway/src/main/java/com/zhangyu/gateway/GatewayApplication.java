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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/10/19
 */
@SpringBootApplication
@Slf4j
public class GatewayApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GatewayApplication.class, args);

        ConfigurableEnvironment environment = context.getEnvironment();

        log.info("网关:\t 地址：http://127.0.0.1:{}", environment.getProperty("server.port"));

    }
}
