package com.zhangyu.quick.dao;

import com.zhangyu.quick.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
//@Mapper
public interface UserMapper {

    MyUser selectUserById(Long id);
}
