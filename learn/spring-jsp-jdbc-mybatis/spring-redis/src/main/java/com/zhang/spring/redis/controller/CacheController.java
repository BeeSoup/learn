package com.zhang.spring.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    @Qualifier("simpleCacheManager")  //可以使用这个来根据名称注入bean
    private CacheManager simpleCacheManager; //也可以使用变量名称获取名称注入

    @PostMapping("saveCache")
    public Object saveCache(@RequestParam String key, @RequestParam String value) {
        //类型推断
        Map<String, String> result = new HashMap<>();

        result.put(key, value);

        Cache testCache = simpleCacheManager.getCache("testCache");

        testCache.put(key, value);

        System.out.println(testCache.get(key).get().toString());

        return result;
    }

}
