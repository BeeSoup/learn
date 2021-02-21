package com.zy.newsource.config.cors;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@NoArgsConstructor
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        // 1. 添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        // 添加允许跨域的前端路径
        config.addAllowedOrigin("http://localhost:8080");
        // config.addAllowedOrigin("*");

        // 设置是否发送cookie信息
        config.setAllowCredentials(true);

        // 设置允许请求的方式
        config.addAllowedMethod("*");

        // 设置允许的header
        config.addAllowedHeader("*");

        // 2. 为所有url添加映射路径 允许认证
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**", config);

        // 3. 返回重新定义好的corsSource
        return new CorsFilter(corsSource);
    }

}
