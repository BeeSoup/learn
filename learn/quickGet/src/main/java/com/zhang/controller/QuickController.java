package com.zhang.controller;


import com.zhang.dao.UserAnnotationMapper;
import com.zhang.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickController {

    @Autowired
    private UserAnnotationMapper mapper;

    @RequestMapping(value = "/request")
    public String getName(@RequestParam int id) {
        MyUser myUser = mapper.selectById(id);
        if (myUser == null) {
            return "no";
        } else {
            return myUser.getName();
        }
    }
}
