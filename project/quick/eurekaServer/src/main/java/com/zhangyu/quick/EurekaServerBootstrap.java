package com.zhangyu.quick;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * EurekaServer启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EurekaServerBootstrap.class)
                .build(args)
                .run();
    }
}
