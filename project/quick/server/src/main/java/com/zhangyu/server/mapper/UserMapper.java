package com.zhangyu.server.mapper;

import com.zhangyu.server.domain.MyUser;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface UserMapper {

    MyUser selectUserById(Long id);
}