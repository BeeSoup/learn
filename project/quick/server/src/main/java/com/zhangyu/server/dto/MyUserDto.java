package com.zhangyu.server.dto;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * 非自动生成，并且不用于mapper 和domain层
 *         先new
 *         BeanUtils.copyProperties();复制
 * 允许修改
 */
@Data
public class MyUserDto implements Serializable {

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