package com.zhangyu.ali.server.controller;

import com.zhangyu.ali.server.dto.User;
import com.zhangyu.ali.server.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class QuickProviderController {

    @GetMapping(value = "/echo/{value}")
    public ResponseData echo(@PathVariable String value) {
        ResponseData responseData = new ResponseData();
        responseData.setData("this is echo ,response :" + value);
        log.info("被调用了");
        return responseData;
    }

    @GetMapping(value = "/echo")
    public ResponseData echo2(@RequestParam(value = "value") String value) {
        ResponseData responseData = new ResponseData();
        responseData.setData("this is echo ,response :" + value);
        log.info("被调用了");
        return responseData;
    }

    @GetMapping("/q")
    public ResponseData query(User user) {
        ResponseData responseData = new ResponseData();
        responseData.setData(user);
        log.info("被调用了");
        return responseData;
    }

    @PostMapping("/q2")
    public ResponseData query2(@RequestBody User user) {
        ResponseData responseData = new ResponseData();
        responseData.setData(user);
        log.info("被调用了");
        return responseData;
    }

}
