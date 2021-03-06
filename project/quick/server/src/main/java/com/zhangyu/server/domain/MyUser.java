package com.zhangyu.server.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 自动生成不允许修改，并且只使用与mapper和domain层
 */
@Data
public class MyUser implements Serializable {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}