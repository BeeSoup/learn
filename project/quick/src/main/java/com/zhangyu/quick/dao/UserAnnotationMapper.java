package com.zhangyu.quick.dao;

import com.zhangyu.quick.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface UserAnnotationMapper {

    //多个返回
    @Results(
            value = {
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "name", column = "name")
            }
    )
    @Select("SELECT * FROM my_user WHERE id = #{id}")
    MyUser selectUserById(Long id);
}
