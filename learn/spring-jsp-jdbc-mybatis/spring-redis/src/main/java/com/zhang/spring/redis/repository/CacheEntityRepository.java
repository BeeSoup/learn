package com.zhang.spring.redis.repository;

import com.zhang.spring.redis.entity.CacheEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 本地缓存的参数测试，通过CaCheName 关联接口结果数据到缓存中
 */
@NoRepositoryBean
public interface CacheEntityRepository {

    /**
     * 存储数据
     */
    void saveCache(CacheEntity entity);

    @Cacheable(cacheNames = "cacheName") //表示接口方法结果返回与缓存绑定，到时候可以走缓存
    CacheEntity findCacheEntityById(int id);

}
