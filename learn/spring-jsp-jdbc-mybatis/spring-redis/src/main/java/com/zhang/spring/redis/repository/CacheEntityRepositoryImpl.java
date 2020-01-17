package com.zhang.spring.redis.repository;

import com.zhang.spring.redis.entity.CacheEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CacheEntityRepositoryImpl implements CacheEntityRepository {

    private final Map<Integer, CacheEntity> repository = new HashMap<>();

    @Override
    public void saveCache(CacheEntity entity) {
        repository.put(entity.getId(), entity);
    }

    @Override
    public CacheEntity findCacheEntityById(int id) {
        return repository.get(id);
    }
}
