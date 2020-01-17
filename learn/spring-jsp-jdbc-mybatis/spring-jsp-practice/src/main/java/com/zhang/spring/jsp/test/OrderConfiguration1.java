package com.zhang.spring.jsp.test;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

/**
 * 无效
 */
//@Configuration
@Order(1)
public class OrderConfiguration1 {

    @PostConstruct
    public void init() {
        System.out.println("run OrderConfiguration1");
    }

    @Bean
    public String orderConfigurationBean1() {
        System.out.println("orderConfigurationBean1" + " is loading");
        return "orderConfigurationBean1";
    }
}
