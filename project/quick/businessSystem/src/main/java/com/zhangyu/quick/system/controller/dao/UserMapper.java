package com.zhangyu.quick.system.controller.dao;

import com.zhangyu.quick.system.controller.domain.MyUser;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface UserMapper {

    MyUser selectUserById(Long id);
}