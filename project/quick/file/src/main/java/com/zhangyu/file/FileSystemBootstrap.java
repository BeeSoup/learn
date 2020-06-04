package com.zhangyu.file;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableDiscoveryClient //也可以配置注册到注册中心去
@Slf4j
public class FileSystemBootstrap {


    public static void main(String[] args) {
//        ConfigurableApplicationContext context = new SpringApplicationBuilder(FileSystemBootstrap.class)
//                .build(args)
//                .run();
//
        SpringApplication springApplication = new SpringApplication(FileSystemBootstrap.class);
        ConfigurableApplicationContext context = springApplication.run();

        ConfigurableEnvironment environment = context.getEnvironment();

        log.info("start");

        log.info("文件上传测试系统: \t http://127.0.0.1:{}", environment.getProperty("server.port"));

    }
}
