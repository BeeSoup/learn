package com.zhang.spring.jsp.service.impl;


import com.zhang.spring.jsp.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
@EnableTransactionManagement
public class SaveServiceImpl implements SaveService {

    @Autowired
    private org.springframework.jdbc.core.JdbcTemplate JdbcTemplate;


    @Override
    @Transactional
    public boolean save() {
        Boolean execute = JdbcTemplate.execute("INSERT INTO test_table(name, age) VALUES (?,?)", new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, "zhang");
                ps.setInt(2, 24);
                int i = ps.executeUpdate();
                return i > 0;
            }
        });
        boolean flag = true;
        if (flag) {
            throw new RuntimeException("事务测试");
        }
        return execute;
    }
}
