package com.zhangyu.ali.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * win 键盘
 * WIN + ALT + L/O
 * Ctrl + ALT + O
 * WIN + SHIFT + 上下
 *
 * WIN = Command
 * alt = option
 * control = ctrl
 * shift = shift
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class QuickServiceProviderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(QuickServiceProviderApplication.class, args);

        ConfigurableEnvironment environment = context.getEnvironment();


        log.info("服务: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
    }

}


