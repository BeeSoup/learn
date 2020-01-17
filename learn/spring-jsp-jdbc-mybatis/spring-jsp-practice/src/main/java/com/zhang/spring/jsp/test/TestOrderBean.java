package com.zhang.spring.jsp.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *  这种模式并不会起效
 */
//@Configuration
public class TestOrderBean {


    @Bean
    @Order
    public String testOrder0() {
        System.out.println("testOrder0" + " is loading");
        return "testOrder0";
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 10)
    public String testOrder1() {
        System.out.println("testOrder1" + " is loading");
        return "testOrder1";
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 20)
    public String testOrder2() {
        System.out.println("testOrder2" + " is loading");
        return "testOrder2";
    }

}
