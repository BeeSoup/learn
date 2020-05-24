package com.zhangyu.quick.controller;

import com.zhangyu.quick.entity.MyUser;
import com.zhangyu.quick.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    private RedisUtil redis;

    @PostMapping(value = "/redisPost")
    public String setRedisByUser(@RequestParam String key, @RequestParam Long id, @RequestParam String name) {
        MyUser user = new MyUser();
        user.setId(id);
        user.setName(name);
        boolean result = redis.set(key, user);
        if (result) {
            return "OK";
        }
        return "Error";
    }

    @GetMapping(value = "/getRedis")
    public String getRedisByKey(@RequestParam String key) {
        MyUser user = redis.get(key, MyUser.class);

        if (user == null) {
            return "Error";
        }

        return "OK: " + key + ", result :" + user.toString();
    }
}
