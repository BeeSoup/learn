package com.zhang.spring.jsp.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

//@Configuration
@Order(2)
public class OrderConfiguration {

    @PostConstruct
    public void init() {
        System.out.println("run OrderConfiguration");
    }

    @Bean
    public String orderConfigurationBean() {
        System.out.println("orderConfigurationBean" + " is loading");
        return "orderConfigurationBean";
    }


}
