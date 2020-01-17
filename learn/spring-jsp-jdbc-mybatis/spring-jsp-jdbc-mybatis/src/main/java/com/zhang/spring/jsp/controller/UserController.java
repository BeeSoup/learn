package com.zhang.spring.jsp.controller;

import com.zhang.spring.jsp.mapping.UserEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping("/user/{id}")
    public UserEntity user(@PathVariable int id) {

        UserEntity user = sqlSessionTemplate.selectOne("com.zhang.spring.jsp.dao.UserMapper.selectAll");

        return user;

    }
}
