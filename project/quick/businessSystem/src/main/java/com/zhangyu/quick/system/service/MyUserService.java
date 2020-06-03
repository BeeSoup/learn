package com.zhangyu.quick.system.service;

import com.zhangyu.quick.system.controller.dao.UserAnnotationMapper;
import com.zhangyu.quick.system.controller.domain.MyUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MyUserService {

    @Resource
    private UserAnnotationMapper userAnnotationMapper;

    public MyUser selectUserById(Long id) {
        return userAnnotationMapper.selectUserById(id);
    }
}