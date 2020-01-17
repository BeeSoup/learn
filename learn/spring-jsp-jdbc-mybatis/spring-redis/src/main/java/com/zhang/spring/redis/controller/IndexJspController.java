package com.zhang.spring.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexJspController {


    @RequestMapping(value = "/indexJsp")
    public String index() {
        return "index";
    }
}
