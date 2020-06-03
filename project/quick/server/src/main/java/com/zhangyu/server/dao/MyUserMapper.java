package com.zhangyu.server.dao;

import com.zhangyu.server.domain.MyUser;
import com.zhangyu.server.domain.MyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyUserMapper {
    long countByExample(MyUserExample example);

    int deleteByExample(MyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MyUser record);

    int insertSelective(MyUser record);

    List<MyUser> selectByExample(MyUserExample example);

    MyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MyUser record, @Param("example") MyUserExample example);

    int updateByExample(@Param("record") MyUser record, @Param("example") MyUserExample example);

    int updateByPrimaryKeySelective(MyUser record);

    int updateByPrimaryKey(MyUser record);
}