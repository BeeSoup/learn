package com.zhang.dao;


import com.zhang.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserAnnotationMapper {


//    @ResultMap("com.zhang.spring.jsp.dao.UserMapper.UserResultMapper")
//    @Results(id = "com.zhang.spring.jsp.dao.UserMapper.UserResultMapper")
    @Results(
            value = {
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "name", column = "name"),
                    @Result(property = "age", column = "age")
            }
    )
    @Select(value = "SELECT id,`name`,age FROM my_user WHERE id = #{id}")
    MyUser selectById(int id);
}
