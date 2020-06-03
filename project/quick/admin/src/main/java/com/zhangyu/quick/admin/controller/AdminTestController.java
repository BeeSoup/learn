package com.zhangyu.quick.admin.controller;

import com.zhangyu.quick.admin.openfeign.RemoteFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminTestController {

    @Resource
    private RemoteFeign remoteFeign;

    @GetMapping(value = "/getYes")
    public String getYes() {
        return remoteFeign.yes();
    }

    @GetMapping(value = "/yes")
    public String yes() {
        return "OK";
    }
}
