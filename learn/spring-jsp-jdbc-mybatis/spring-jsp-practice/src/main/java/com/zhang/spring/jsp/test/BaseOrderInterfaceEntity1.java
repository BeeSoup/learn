package com.zhang.spring.jsp.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = false)
@Order(10)
public class BaseOrderInterfaceEntity1 implements BaseOrderInterface {

    private String name = "BaseOrderInterfaceEntity1";


    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getName() + "   is loading");
    }

    @Override
    public void run() {
        System.out.println("BaseOrderInterfaceEntity1 is run");
    }
}
