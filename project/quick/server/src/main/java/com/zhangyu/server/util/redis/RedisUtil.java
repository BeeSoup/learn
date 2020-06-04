package com.zhangyu.server.util.redis;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

/**
 * 以Jedis封装redis工具类
 *        或者使用redisTemplate 封装一下
 */
@Component(value = "redis")
@Slf4j
public class RedisUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private JedisPool jedisPool;

    private JedisPool jedisPool;

    private RedisTemplate redisTemplate;

    //构造器和Set方法注入.IDEA不警告
    @Autowired
    public RedisUtil(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    //set方法注入
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


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
            if (redisValue == null) {
                return null;
            }
            t = stringToBean(redisValue, clazz);
        } finally {
            returnResource(jedis);
        }
        return t;
    }

    /**
     *
     *
     */
    public <T> boolean templateSet(String key, T value) {
        boolean result = false;
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * 过期key设置
     */
    public <T> boolean templateSet(String key, T value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     *
     * @param key
     * @return
     */
    public Object templateGet(String key) {
        Object result = null;
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            result = valueOperations.get(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     *
     * @param key
     * @return
     */
    public boolean templateExists(String key) {
        boolean result = false;
        try {
            result = redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
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
