package com.zhang.spring.jsp.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = false)
@Order(8)
public class BaseOrderInterfaceEntity2 implements BaseOrderInterface{

    private String name = "BaseOrderInterfaceEntity2";

    @PostConstruct
    public void init() {
        System.out.println(this.getClass().getName() + "   is loading");
    }

    @Override
    public void run() {
        System.out.println("BaseOrderInterfaceEntity2 is run");
    }
}
