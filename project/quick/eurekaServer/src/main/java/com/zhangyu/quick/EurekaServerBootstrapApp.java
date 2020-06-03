package com.zhangyu.quick;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * EurekaServer启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerBootstrapApp {

    private static Logger log = LoggerFactory.getLogger(EurekaServerBootstrapApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EurekaServerBootstrapApp.class)
                .build(args)
                .run();
        ConfigurableEnvironment environment = context.getEnvironment();

        log.info("start");
        log.info("Eureka地址: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
    }
}
