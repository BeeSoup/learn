package com.zhangyu.quick.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//配置扫描路径
@MapperScan(value = "com.zhangyu.quick.dao")
public class MybatisConfigurationBean {
}
