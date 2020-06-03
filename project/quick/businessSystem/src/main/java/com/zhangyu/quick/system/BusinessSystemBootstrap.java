package com.zhangyu.quick.system;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableEurekaClient
//配置扫描路径
@MapperScan(value = "com.zhangyu.server.mapper")
//默认扫描启动类所在路径下所有的bean
//意外的路径，配置扫描路径
@ComponentScan(value = "com.zhangyu")
public class BusinessSystemBootstrap {

    private static Logger log = LoggerFactory.getLogger(BusinessSystemBootstrap.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(BusinessSystemBootstrap.class)
                .build(args)
                .run();
        ConfigurableEnvironment environment = context.getEnvironment();

        log.info("start");

        log.info("业务系统地址: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
    }

}
