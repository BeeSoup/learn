package com.zhangyu.ali.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * spring-cloud-alibaba
 * 版本的入门学习。
 * 将会，学习包括命名规则，
 * 注释写法规则的学习。
 * 起步阶段。
 */

@MapperScan("com.zhangyu")
@SpringBootApplication
public class CloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }

}
