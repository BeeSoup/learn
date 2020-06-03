package com.zhangyu.quick.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


@EnableEurekaClient
// 激活openFeign既可以通过Feign进行服务调用
@EnableFeignClients
// value值表示: 本次负载均衡算法作用到的服务名称
// configuration属性值表示: 自定义的算法类的Class对象
//(如果我们不使用RibbonClient注解,openFeign会默认使用Ribbon的轮询算法)
//@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = IRuleConfig.class)
@SpringBootApplication
public class AdminBootstrap {

    private static Logger log = LoggerFactory.getLogger(AdminBootstrap.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AdminBootstrap.class)
                .build(args)
                .run();
        ConfigurableEnvironment environment = context.getEnvironment();

        log.info("start");

        log.info("admin feign系统地址: \t http://127.0.0.1:{}", environment.getProperty("server.port"));
    }

}
