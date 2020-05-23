package com.zhangyu.cloud.config;


import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyConfiguration implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // 定义一个新的PropertySources
        MutablePropertySources propertySources = environment.getPropertySources();
        // 定义一个新的PropertySource
        propertySources.addFirst(createPropertySource());
    }

    private PropertySource createPropertySource() {
        Map<String, Object> source = new HashMap<>();

        source.put("name", "zhang");

        MapPropertySource propertySource = new MapPropertySource("my-key", source);

        return propertySource;
    }
}
