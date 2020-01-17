package com.zhang.spring.redis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/7 14:46
 */
//@Configuration
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        if (redisTemplate == null) {
            System.out.println("模版为空，无法操作");
            return false;
        }
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        if (redisTemplate == null) {
            System.out.println("模版为空，无法操作");
            return false;
        }
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }
}
