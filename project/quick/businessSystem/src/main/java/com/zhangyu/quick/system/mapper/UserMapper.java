package com.zhangyu.quick.system.mapper;

import com.zhangyu.quick.system.domain.MyUser;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface UserMapper {

    MyUser selectUserById(Long id);
}