package com.zy.newsource.service.impl;

import com.zy.newsourcce.pojo.datasource.entity.Users;
import com.zy.newsource.pojo.datasource.dao.UsersMapper;
import com.zy.newsource.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO...
 *
 * @author zhang
 * @since 2021/2/21
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public String getUserStr(String id) {
        Users users = usersMapper.selectById(id);
        return users.toString();
    }
}
