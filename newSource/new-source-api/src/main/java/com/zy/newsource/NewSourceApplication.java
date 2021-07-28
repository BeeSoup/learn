package com.zy.newsource;

import com.zy.newsource.config.webconfig.ServerProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.zy.newsource.pojo.datasource.dao"})
@EnableConfigurationProperties(ServerProperties.class)
// @EnableScheduling 开启定时任务
public class NewSourceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(NewSourceApplication.class, args);
//        Bootstrap
//        run.getBean()
    }

}
