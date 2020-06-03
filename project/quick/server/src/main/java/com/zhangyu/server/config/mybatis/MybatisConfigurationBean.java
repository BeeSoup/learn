package com.zhangyu.server.config.mybatis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//配置扫描路径 放在这里，加载顺序有误，不能放
//@MapperScan(value = "com.zhangyu.quick.system.mapper")
@ConfigurationProperties(prefix = "common")//用于绑定属性，其中prefix表示所绑定的属性的前缀。
//@PropertySource(value = "config.properties")//表示配置文件路径。
//@PropertySource(value = {"classpath:/redis/redis.properties"}, encoding = "UTF-8")
//@Profile("testdb") //什么配置下，加载
public class MybatisConfigurationBean {

}


