package com.zhangyu.server.redis;

import com.zhangyu.server.dto.RedisDomainDto;
import com.zhangyu.server.util.UuidUtil;
import com.zhangyu.server.util.redis.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource(name = "redis")
    RedisUtil redis;


    /**
     * 使用原生jedis 存储
     */
    public String setRedisJedis(String key, String name) {
        RedisDomainDto domainDto = new RedisDomainDto();
        domainDto.setId(UuidUtil.getShortUuid());
        domainDto.setName(name);
        boolean result = redis.set(key, domainDto);
        if (result) {
            return "OK";
        }
        return "Error";
    }

    /**
     * 原生jedis 获取
     */
    public RedisDomainDto getRedisJedis(String key) {
        RedisDomainDto domainDto = redis.get(key, RedisDomainDto.class);

        return domainDto;
    }

    /**
     * redisTemplate 保存
     */
    public String setRedisTemplate(String key, String name) {
        RedisDomainDto domainDto = new RedisDomainDto();
        domainDto.setId(UuidUtil.getShortUuid());
        domainDto.setName(name);
        boolean result = redis.templateSet(key, domainDto, 60000l);
        if (result) {
            return "OK";
        }
        return "Error";
    }

    /**
     * redisTemplate 获取
     */
    public RedisDomainDto getRedisTemplate(String key) {
        Object value = redis.templateGet(key);
        RedisDomainDto domainDto = null;
        // 未过期，或者还能获取到，才会做类型转换
        if (value != null) {
            domainDto = RedisDomainDto.class.cast(value);
        }
        return domainDto;
    }
}
