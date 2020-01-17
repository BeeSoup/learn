package com.zhang.spring.jsp.dao;

import com.zhang.spring.jsp.mapping.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class UserMain {

    public static void main(String[] args) throws Exception {

        System.out.println(System.getProperty("user.dir") + "/spring-jsp-jdbc-mybatis");

        ResourceLoader loader = new DefaultResourceLoader();

        Resource resource = loader.getResource("classpath:/mybatis/mybatis-config.xml");

        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        Reader reader = encodedResource.getReader();

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory build = sqlSessionFactoryBuilder.build(reader, "macDev", new Properties());

        SqlSession sqlSession = build.openSession();

        List<UserEntity> users = sqlSession.selectList("com.zhang.spring.jsp.dao.UserMapper.selectAll");

        for (UserEntity entity : users) {
            System.out.println(entity);
        }

        sqlSession.close();
    }
}
