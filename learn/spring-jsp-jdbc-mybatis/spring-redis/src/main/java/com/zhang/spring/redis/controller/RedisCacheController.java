package com.zhang.spring.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisCacheController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/get")
    public Object getCache() {

        String bookName = redisTemplate.opsForValue().get("bookName").toString();

        return bookName;
    }


    @RequestMapping("/save")
    public Object saveCache() {

        redisTemplate.opsForValue().set("bookName", "springboot");

        return "success";
    }

}
