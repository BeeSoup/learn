package com.zy.newsource.controller;

import com.zy.newsourcce.pojo.datasource.entity.Users;
import com.zy.newsource.pojo.datasource.dao.UsersMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@RestController
// 可以忽略API
@ApiIgnore
public class HelloController {


    @Resource
    private UsersMapper usersMapper;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/hello")
    public String hello() {
        Users users = usersMapper.selectById("1908017YR51G1XWH");
        int i = 1/0;
        return users.toString();
    }
}
