package com.zhang.spring.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class IndexJspController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "/indexJsp")
    public String index() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
        return "index";
    }
}
