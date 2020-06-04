package com.zhangyu.server.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 序列化对象，都要标记序列化
 */
@Data
public class RedisDomainDto implements Serializable {

    private String id;

    private String name;

    @Override
    public String toString() {
        return "RedisDomainDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
