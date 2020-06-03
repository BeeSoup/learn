package com.zhangyu.quick.system.controller;

import com.zhangyu.server.domain.MyUser;
import com.zhangyu.server.mybatis.MyUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class QuickTestController {

    @Resource
    private MyUserService myUserService;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private RedisUtil redis;

    @GetMapping(value = "/getTest")
    public String getTest(@RequestParam String who) {
        return who + " : OK";
    }

    @RequestMapping(value = "/yes")
    public String yes() {
        return "success:OK";
    }

    //    @GetMapping(value = "/getAnnotationUserTest")
//    public String getAnnotationUserTest(Long id) {
//        MyUser myUser = annotationMapper.selectUserById(id);
//        return myUser.toString() + ": OK!";
//    }
//
//
    @GetMapping(value = "/getUserTest")
    public String getUserTest(@RequestParam Long id) {
        MyUser myUser = myUserService.selectUserById(id);
        return myUser != null ? myUser.toString() : "null" + ": OK!";
    }
//
//    @GetMapping(value = "/errorTest")
//    public String errorTest() {
//        boolean flag = true;
//        if (flag) {
//            throw new RuntimeException("I is wrong!");
//        }
//        return "OK";
//    }
//
//    /**
//     * 逻辑代码应该写到service里面，注意调整
//     * 并且对于User，也可以存放到ThreadLocal里面，这一部分，需要过滤器存放，然后，如果请求结束，需要删除key-value
//     */
//    @PostMapping(value = "/login")
//    public String login(@RequestParam String keyId, HttpServletResponse response) {
//        String token = UUIDUtil.getUUID();
//        //设置用户
//        redis.templateSet(token, token, 10000l);
//        Cookie cookie = new Cookie("yourName", token);
//        //与过期时间一致
//        cookie.setMaxAge(10000);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//        return "OK";
//    }
}
