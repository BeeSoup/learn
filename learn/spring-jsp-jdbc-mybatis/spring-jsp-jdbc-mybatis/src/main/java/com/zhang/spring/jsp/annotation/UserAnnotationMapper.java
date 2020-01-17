package com.zhang.spring.jsp.annotation;

import com.zhang.spring.jsp.mapping.UserEntity;
import org.apache.ibatis.annotations.*;

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
    @Select(value = "SELECT id,`name`,age FROM user_table WHERE id = #{id}")
    UserEntity selectAll(int id);
}
