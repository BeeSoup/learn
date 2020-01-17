package com.zhang.spring.jsp.dao;

import com.zhang.spring.jsp.entity.UserTable;
import com.zhang.spring.jsp.entity.UserTableExample;
import com.zhang.spring.jsp.mapping.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class GeneratorUserMain {

    public static void main(String[] args) throws Exception {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        InputStream inputStream = loader.getResourceAsStream("mybatis/mybatis-config.xml");

        Reader reader = new InputStreamReader(inputStream, "UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory build = builder.build(reader, "macDev", new Properties());

        SqlSession sqlSession = build.openSession();

        UserTableMapper mapper = sqlSession.getMapper(UserTableMapper.class);

        UserTableExample example = new UserTableExample();

        List<UserTable> userTables = mapper.selectByExample(example);

        for (UserTable entity : userTables) {
            System.out.println(entity);
        }


        sqlSession.close();

    }
}
