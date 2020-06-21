package com.zhangyu.ali.cloud.controller;


import com.zhangyu.ali.cloud.dao.myUser.MyUserMapper;
import com.zhangyu.ali.cloud.domain.entity.myUser.MyUser;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {


    private final MyUserMapper myUserMapper;


    @GetMapping("/test/{id}")
    public MyUser getUser(@PathVariable String id) {
        MyUser myUser = this.myUserMapper.selectByPrimaryKey(id);
        TestMy build = TestMy.builder()
                .age(12)
                .build();
        return myUser;
    }

//    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject("http://localhost:9090/test/9", String.class);
//        System.out.println(forObject);
//    }
    //19:18:30.616 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP GET http://localhost:9090/test/9
    //19:18:30.624 [main] DEBUG org.springframework.web.client.RestTemplate - Accept=[text/plain, application/json, application/*+json, */*]
    //Exception in thread "main" org.springframework.web.client.ResourceAccessException: I/O error on GET request for "http://localhost:9090/test/9": Connection refused (Connection refused); nested exception is java.net.ConnectException: Connection refused (Connection refused)
    //	at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:748)
    //	at org.springframework.web.client.RestTemplate.execute(RestTemplate.java:674)
    //	at org.springframework.web.client.RestTemplate.getForObject(RestTemplate.java:315)
    //	at com.zhangyu.ali.cloud.controller.TestController.main(TestController.java:38)
    //Caused by: java.net.ConnectException: Connection refused (Connection refused)
    //	at java.net.PlainSocketImpl.socketConnect(Native Method)
    //	at java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)
    //	at java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)
    //	at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)
    //	at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)
    //	at java.net.Socket.connect(Socket.java:589)
    //	at java.net.Socket.connect(Socket.java:538)
    //	at sun.net.NetworkClient.doConnect(NetworkClient.java:180)
    //	at sun.net.www.http.HttpClient.openServer(HttpClient.java:463)
    //	at sun.net.www.http.HttpClient.openServer(HttpClient.java:558)
    //	at sun.net.www.http.HttpClient.<init>(HttpClient.java:242)
    //	at sun.net.www.http.HttpClient.New(HttpClient.java:339)
    //	at sun.net.www.http.HttpClient.New(HttpClient.java:357)
    //	at sun.net.www.protocol.http.HttpURLConnection.getNewHttpClient(HttpURLConnection.java:1220)
    //	at sun.net.www.protocol.http.HttpURLConnection.plainConnect0(HttpURLConnection.java:1156)
    //	at sun.net.www.protocol.http.HttpURLConnection.plainConnect(HttpURLConnection.java:1050)
    //	at sun.net.www.protocol.http.HttpURLConnection.connect(HttpURLConnection.java:984)
    //	at org.springframework.http.client.SimpleBufferingClientHttpRequest.executeInternal(SimpleBufferingClientHttpRequest.java:76)
    //	at org.springframework.http.client.AbstractBufferingClientHttpRequest.executeInternal(AbstractBufferingClientHttpRequest.java:48)
    //	at org.springframework.http.client.AbstractClientHttpRequest.execute(AbstractClientHttpRequest.java:53)
    //	at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:739)
    //	... 3 more

    //同一个启用，连接拒绝。
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
