package com.zhangyu.quick.system.service;

import com.zhangyu.quick.system.mapper.UserAnnotationMapper;
import com.zhangyu.quick.system.domain.MyUser;
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