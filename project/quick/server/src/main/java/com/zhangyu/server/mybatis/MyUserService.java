package com.zhangyu.server.mybatis;

import com.zhangyu.server.mapper.UserAnnotationMapper;
import com.zhangyu.server.domain.MyUser;
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