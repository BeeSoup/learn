package com.zhangyu.service.consumer.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

//@RibbonClient(name = "${zhangyu.service.provider}", configuration = {
//        RibbonConfiguration.class
//})
//@Configuration
// 全局配置ribbon
@RibbonClients(defaultConfiguration = {
        RibbonConfiguration.class
})
@Configuration
public class RibbonConfiguration {
}
