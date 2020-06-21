package com.zhangyu.ali.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickProviderController {

    @GetMapping(value = "/echo/{value}")
    public String echo(@PathVariable String value) {
        return "this is echo ,response :" + value;
    }
}
