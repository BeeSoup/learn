package com.zhangyu.quick.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.zhangyu.quick.dao")
public class MybatisConfigurationBean {
}
