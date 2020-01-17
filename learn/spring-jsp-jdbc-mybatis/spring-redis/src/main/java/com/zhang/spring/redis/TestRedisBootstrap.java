package com.zhang.spring.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * JSP找不到，没有配置工作路径
 */
@SpringBootApplication
public class TestRedisBootstrap {

    public static void main(String[] args) {
//        SpringApplication.run(TestRedisBootstrap.class, args);
        //使用Builder方式启动
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TestRedisBootstrap.class)
                .build(args)
                .run();

//        context.close();
    }
}
