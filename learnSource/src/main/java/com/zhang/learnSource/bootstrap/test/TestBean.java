package com.zhang.learnSource.bootstrap.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO...
 *
 * @author zy
 * @since 2021/2/9
 */
@Configuration
public class TestBean {

    @Bean
    public String testMyBean() {
        return "this bean is start";
    }
}
