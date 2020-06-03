package com.zhangyu.server.mapper;


import com.zhangyu.server.domain.MyUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserAnnotationMapper {

    //多个返回
    @Results(
            value = {
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "name", column = "name")
            }
    )
    @Select("SELECT * FROM my_user WHERE id = #{id}")
    MyUser selectUserById(@Param("id") Long id);
}
