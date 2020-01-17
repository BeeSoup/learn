package com.zhang.spring.jsp.annotation;

import com.zhang.spring.jsp.mapping.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class UserAnnotationMain {

    public static void main(String[] args) {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        InputStream resourceAsStream = loader.getResourceAsStream("mybatis/mybatis-config.xml");

        Reader reader = new InputStreamReader(resourceAsStream);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(reader, "macDev", new Properties());


        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);

        UserEntity entity = mapper.selectAll(123);

        System.out.println(entity);

        sqlSession.close();

    }
}
