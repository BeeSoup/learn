package com.zhang.spring.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexJspController {


    @RequestMapping(value = "/indexJsp")
    public String index() {
        return "index";
    }
}
