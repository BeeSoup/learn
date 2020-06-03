package com.zhangyu.server.mybatis;

import com.github.pagehelper.PageHelper;
import com.zhangyu.server.dto.MyUserDto;
import com.zhangyu.server.mapper.UserAnnotationMapper;
import com.zhangyu.server.domain.MyUser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MyUserService {

    @Resource
    private UserAnnotationMapper userAnnotationMapper;

    public MyUser selectUserById(Long id) {
        return userAnnotationMapper.selectUserById(id);
    }

    /**
     * 做一个转换
     */
    public MyUserDto selectUserDtoById(Long id) {
        PageHelper.startPage(1, 1);//从第一页开始，找一条， 然后遇到的第一个Mapper 执行SQL插入limit分页
        MyUser myUser = userAnnotationMapper.selectUserById(id);
        MyUserDto myUserDto = new MyUserDto();
        BeanUtils.copyProperties(myUser, myUserDto);
        return myUserDto;
    }
}