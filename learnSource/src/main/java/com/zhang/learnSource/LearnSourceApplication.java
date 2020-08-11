package com.zhang.learnSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 扫描注册servlet
@ServletComponentScan(basePackages = "com.zhang.learnSource.web.servlet")
public class LearnSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSourceApplication.class, args);
    }

}
