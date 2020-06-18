package com.zhangyu.ali.cloud.controller;

import com.sun.istack.internal.NotNull;
import com.zhangyu.ali.cloud.dao.myUser.MyUserMapper;
import com.zhangyu.ali.cloud.domain.entity.myUser.MyUser;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

//    private final MyUserMapper myUserMapper;

    @NotNull
    private MyUserMapper myUserMapper;

    private final MyUserMapper myUserMapper2;


    @GetMapping("/test/{id}")
    public MyUser getUser(@PathVariable String id) {
        MyUser myUser = this.myUserMapper.selectByPrimaryKey(id);
        TestMy build = TestMy.builder()
                .age(12)
                .build();
        return myUser;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:9090/test/9", String.class);
        System.out.println(forObject);
    }
}

/**
 * 编译期添加了
 * class文件里已经添加了 get和set方法
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class TestMy {
    private Integer id;
    private Integer age;
    private String name;
}
