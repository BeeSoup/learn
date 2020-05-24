package com.zhangyu.quick.util.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 以Jedis封装redis工具类
 */
@Component(value = "redis")
public class RedisUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private JedisPool jedisPool;

    private JedisPool jedisPool;

    //构造器和Set方法注入.IDEA不警告
    @Autowired
    public RedisUtil(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

//    @Autowired
//    public void setJedisPool(JedisPool jedisPool) {
//        this.jedisPool = jedisPool;
//    }

    public <T> boolean set(String key, T value) {
        Jedis jedis = null;
        try {
            if (value == null) {
                return false;
            }
            jedis = jedisPool.getResource();
            String beanString = beanToString(value);
            jedis.set(key, beanString);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        } finally {
            returnResource(jedis);
        }
        return true;
    }


    public <T> T get(String key, Class<T> clazz) {
        T t = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String redisValue = jedis.get(key);
            t = stringToBean(redisValue, clazz);
        } finally {
            returnResource(jedis);
        }
        return t;
    }

    //Bean转String
    private <T> String beanToString(T value) {
        String json = JSON.toJSONString(value);
        return json;
    }

    //String转Bean
    private <T> T stringToBean(String redisValue, Class<T> clazz) {
        T t = (T) JSON.toJavaObject(JSON.parseObject(redisValue), clazz);
        return t;
    }

    //归还Jedis
    private void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }


}
