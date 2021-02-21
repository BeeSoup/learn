package com.zy.newsource.controller;

import com.zy.newsourcce.pojo.datasource.dto.UserDTO;
import com.zy.newsource.service.HelloService;
import com.zy.newsource.util.CookieUtils;
import com.zy.newsource.util.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@Api(value = "测试", tags = {"左上边主要显示名称"})
public class HelloController2 {


    @Autowired
    private HelloService helloService;

    @ApiOperation(value = "获取hello2", notes = "获取hello21111", httpMethod = "GET")
    @GetMapping("/hello2")
    public String hello2(HttpServletRequest request) {
        String userId = CookieUtils.getCookieValue(request, "userId", true);
        System.out.println(userId);
        return helloService.getUserStr("1908017YR51G1XWH");
    }

    @ApiOperation(value = "标题栏", notes = "标题栏点击后的说明", httpMethod = "GET", response = String.class)
    @GetMapping("/hello3")
    public String hello3(@ApiParam("这是参数说明") @RequestBody UserDTO userDTO) {
        return helloService.getUserStr(userDTO.getId());
    }

    @ApiOperation(value = "获取hello4", notes = "获取hello41111", httpMethod = "GET")
    @GetMapping("/hello4")
    public String hello4(@ApiParam("yesId") @RequestParam String id) {
        return helloService.getUserStr(id);
    }


    @GetMapping("/setSession")
    public Object setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // 设置值
        session.setAttribute("userInfo", "new user");
        // 过期时间
        session.setMaxInactiveInterval(3600);
        session.getAttribute("userInfo");
//        session.removeAttribute("userInfo");
        return "ok";
    }

    @GetMapping("/setCookie")
    public Object setCookie(HttpServletRequest request, HttpServletResponse response) {
        UserDTO userDTO = UserDTO.builder()
                .id("2222")
                .build();
        // isEncode 是否加密
        CookieUtils.setCookie(request, response, "userId", JsonUtils.objectToJson(userDTO), true);
        return "ok";
    }
}
