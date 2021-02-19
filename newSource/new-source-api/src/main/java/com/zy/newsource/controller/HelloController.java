package com.zy.newsource.controller;

import com.zy.newsourcce.pojo.datasource.entity.Users;
import com.zy.newsource.pojo.datasource.dao.UsersMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {


    @Resource
    private UsersMapper usersMapper;

    @GetMapping("/hello")
    public String hello() {
        Users users = usersMapper.selectById("1908017YR51G1XWH");
        return users.toString();
    }
}
