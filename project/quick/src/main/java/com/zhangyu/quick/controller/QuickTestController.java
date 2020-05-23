package com.zhangyu.quick.controller;

import com.zhangyu.quick.dao.UserAnnotationMapper;
import com.zhangyu.quick.dao.UserMapper;
import com.zhangyu.quick.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickTestController {

    @Autowired
    private UserAnnotationMapper annotationMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/getTest")
    public String getTest(String who) {
        return who + " : OK";
    }

    @GetMapping(value = "/getAnnotationUserTest")
    public String getAnnotationUserTest(Long id) {
        MyUser myUser = annotationMapper.selectUserById(id);
        return myUser.toString() + ": OK!";
    }


    @GetMapping(value = "/getUserTest")
    public String getUserTest(Long id) {
        MyUser myUser = userMapper.selectUserById(id);
        return myUser.toString() + ": OK!";
    }
}
