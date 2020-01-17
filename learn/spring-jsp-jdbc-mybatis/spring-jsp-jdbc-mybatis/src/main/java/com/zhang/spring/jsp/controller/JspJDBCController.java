package com.zhang.spring.jsp.controller;

import com.zhang.spring.jsp.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.CallableStatement;
import java.sql.SQLException;

@RestController("index")
public class JspJDBCController {

    @Autowired
    private JdbcTemplate JdbcTemplate;

    @Autowired
    private SaveService saveService;

    @RequestMapping(value = "/getResutl")
    public Object getResult() {
        boolean save = saveService.save();
        return save;
    }
}
