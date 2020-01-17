package com.zhang.spring.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching//开启本地缓存配置 将会绑定结果
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager() {

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        ConcurrentMapCache testCache = new ConcurrentMapCache("testCache");

        ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");

        ConcurrentMapCache cacheName = new ConcurrentMapCache("cacheName");

        simpleCacheManager.setCaches(Arrays.asList(testCache, cache, cacheName));

//        simpleCacheManager.setCaches(Collections.singleton(testCache));

        return simpleCacheManager;
    }

}
