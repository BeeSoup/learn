package com.zhangyu.quick.system.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//配置扫描路径 放在这里，加载顺序有误，不能放
//@MapperScan(value = "com.zhangyu.quick.system.mapper")
public class MybatisConfigurationBean {
}
