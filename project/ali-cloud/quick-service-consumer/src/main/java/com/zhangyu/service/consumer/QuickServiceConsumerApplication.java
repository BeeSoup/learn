package com.zhangyu.service.consumer;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.client.RestTemplate;


@Slf4j
@EnableDiscoveryClient
@EnableFeignClients
// 全局配置
//@EnableFeignClients(defaultConfiguration = {
//
//})
@SpringBootApplication
public class QuickServiceConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(QuickServiceConsumerApplication.class, args);

        ConfigurableEnvironment environment = context.getEnvironment();


        log.info("消费:\t 地址：http://127.0.0.1:{}", environment.getProperty("server.port"));

    }


    /**
     * 支持ribbon的负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 整合sentinel restTemplate
     * @return
     */
    @Bean
    @LoadBalanced
    @SentinelRestTemplate
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }

    /**
     * 普通的restTemplate
     * @return
     */
    @Bean
    public RestTemplate restTemplateUnLoadBalance() {
        return new RestTemplate();
    }
}
