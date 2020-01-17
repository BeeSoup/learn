package com.zhang.spring.redis.controller;

import com.zhang.spring.redis.entity.CacheEntity;
import com.zhang.spring.redis.repository.CacheEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cacheEntity")
public class CacheEntityController {

    @Autowired
    @Qualifier("simpleCacheManager")
    private CacheManager manager;

    @Autowired
    private CacheEntityRepository repository;

    @GetMapping("/find/{id}")
    public CacheEntity findCacheEntity(@PathVariable int id) {
        return repository.findCacheEntityById(id);
    }

    @PostMapping("/save")
    public CacheEntity saveCacheEntity(@RequestBody CacheEntity entity) {

        repository.saveCache(entity);

        return entity;
    }

}
