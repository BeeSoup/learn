package com.zhangyu.ali.server.controller;

import com.zhangyu.ali.server.entity.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickProviderController {

    @GetMapping(value = "/echo/{value}")
    public ResponseData echo(@PathVariable String value) {
        ResponseData responseData = new ResponseData();
        responseData.setData("this is echo ,response :" + value);
        return responseData;
    }
}
