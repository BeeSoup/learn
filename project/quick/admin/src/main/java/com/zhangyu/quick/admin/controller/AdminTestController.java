package com.zhangyu.quick.admin.controller;

import com.zhangyu.quick.admin.openfeign.RemoteFeign;
import com.zhangyu.quick.admin.openfeign.RemoteGateWayFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdminTestController {
    public static final String BUSINESS_NAME = "Admin";

    @Resource
    private RemoteFeign remoteFeign;
    @Resource
    private RemoteGateWayFeign remoteGateWayFeign;

    @GetMapping(value = "/getYes")
    public String getYes() {
        return remoteFeign.yes();
    }

    @GetMapping(value = "/getTest")
    public String getTest(@RequestParam String who) {
        return remoteGateWayFeign.getTest(who);
    }

    @GetMapping(value = "/yes")
    public String yes() {
        return "OK";
    }
}
