package com.zhangyu.ali.cloud.domain.entity.myUser;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@Table(name = "my_user")
public class MyUser {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private Integer age;

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}