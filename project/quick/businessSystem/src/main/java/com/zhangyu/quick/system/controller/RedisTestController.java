package com.zhangyu.quick.system.controller;


import com.zhangyu.server.dto.RedisDomainDto;
import com.zhangyu.server.redis.RedisService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RedisTestController {

    @Resource
    RedisService service;

    @PostMapping(value = "/save")
    public String saveRedisByJedis(@RequestParam String key, @RequestParam String name) {
        return service.setRedisJedis(key, name);
    }

    @PostMapping(value = "/save/{key}/{name}")
    public String saveRedisByTemplate(@PathVariable String key, @PathVariable String name) {
        return service.setRedisTemplate(key, name);
    }


    @GetMapping(value = "/get")
    public RedisDomainDto getRedisJedis(@RequestParam String key) {
        return service.getRedisJedis(key);
    }

    @GetMapping(value = "/get/{key}")
    public RedisDomainDto getRedisTemplate(@PathVariable String key) {
        return service.getRedisTemplate(key);
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:9090/test/9", String.class);
//        restTemplate.postForObject("http://localhost:9090/test/{id}",new Request()
//                String.class,2);
        //属性拷贝
        BeanUtils.copyProperties(new Object(), new Object());
        System.out.println(forObject);
    }

}
