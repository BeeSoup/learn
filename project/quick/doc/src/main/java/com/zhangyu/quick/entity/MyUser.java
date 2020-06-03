package com.zhangyu.quick.entity;

import lombok.Data;

import java.io.Serializable;

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
