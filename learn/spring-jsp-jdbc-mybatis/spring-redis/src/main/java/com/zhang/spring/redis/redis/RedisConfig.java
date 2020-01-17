//package com.zhang.spring.redis.redis;//package com.zhangyu.three.redis;
//
//import com.alibaba.fastjson.parser.ParserConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author yu.zhang
// * @Description: TODO
// * @date 2019/8/7 14:05
// */
////@Configuration
//public class RedisConfig {
//
//
////    @Bean
//    public RedisSerializer getFastJson2JsonRedisSerializer(){
//        System.out.println("向spring注入json方法");
//        return new FastJson2JsonRedisSerializer<Object>(Object.class);
//    }
//
////    @Bean
//    public RedisTemplate getRedisTemplate(RedisConnectionFactory connectionFactory){
//        System.out.println("获取模版方法");
//
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        ParserConfig.getGlobalInstance().addAccept("com.zhangyu.");
//        // 开启事务
//        redisTemplate.setEnableTransactionSupport(true);
//
//        //key
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//
//        //value
//        redisTemplate.setValueSerializer(getFastJson2JsonRedisSerializer());
//        redisTemplate.setHashValueSerializer(getFastJson2JsonRedisSerializer());
//
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//}
