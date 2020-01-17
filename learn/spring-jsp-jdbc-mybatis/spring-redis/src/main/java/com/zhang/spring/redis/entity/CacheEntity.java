package com.zhang.spring.redis.entity;

import java.io.Serializable;


/**
 * 缓存实体测试
 */
public class CacheEntity implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
