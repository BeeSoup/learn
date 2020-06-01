package com.zhangyu.quick.config.redis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 */
@Configuration
@PropertySource(value = "classpath:/config/redis/redis.properties")
@ConfigurationProperties(prefix = "zhangyu")
@Data
@Slf4j
public class RedisConfigurationBean {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.block-when-exhausted}")
    private boolean blockWhenExhausted;

    private String name;

    @Value("${zhangyu.name}")
    private String zhangyuName = "OJBK";


    //jedisPool Bean
    @Bean
    public JedisPool redisPoolFactory() throws Exception {
        logger.info(String.format("开始 name : %s, zhangyuName: %s", name, zhangyuName));
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);

        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        logger.info("jedis is create success!");
        return jedisPool;
    }


    @Bean
    public RedisSerializer fastJson2JsonRedisSerializer() {
        return new FastJson2JsonRedisSerializer<Object>(Object.class);
    }

    @Bean
    public RedisSerializer jdkJsonRedisSerializer() {
        return new JDKJsonRedisSerializer();
    }

    //自定义的RedisConnectionFactory 有空看源码分析 所有的属性取配置里的
//    @Bean
//    @ConditionalOnMissingBean(RedisConnectionFactory.class)
//    public RedisConnectionFactory redisConnectionFactory() {
//
//    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory,
                                       RedisSerializer jdkJsonRedisSerializer, RedisSerializer fastJson2JsonRedisSerializer) {
        log.info("redisTemplate is begin");
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        //设置一下连接的 这个后期看看能不能配置也自定义化，需要看源码查看需要配置什么东东
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //日常的key value设置，JDK序列化IO性能不知道如何，有空也测试一下
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jdkJsonRedisSerializer);

        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jdkJsonRedisSerializer);
        log.info("redisTemplate is success");
        return redisTemplate;
    }

}
