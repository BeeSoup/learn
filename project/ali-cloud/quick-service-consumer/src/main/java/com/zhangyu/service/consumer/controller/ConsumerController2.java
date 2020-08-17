package com.zhangyu.service.consumer.controller;

import com.zhangyu.service.consumer.entity.ResponseData;
import com.zhangyu.service.consumer.entity.UserDTO;
import com.zhangyu.service.consumer.openfeign.ConsumeFeignClient;
import com.zhangyu.service.consumer.openfeign.TestBaiduFeignClient;
import com.zhangyu.service.consumer.openfeign.TestConsumeFeignClient;
import com.zhangyu.service.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConsumerController2 {


    @Autowired
    private ConsumerService consumerService;


    @Value("${zhangyu.service.provider}")
    private String provider;

    @Autowired
    private ConsumeFeignClient consumeFeignClient;

    @Autowired
    private TestConsumeFeignClient testConsumeFeignClient;

    //"http://service-provider/echo/"
    @GetMapping("/consumer2/{value}")
    public ResponseData consumer2(@PathVariable String value) {
        ResponseData<String> response = this.consumeFeignClient.findStringById(value);
        log.info("response： \t {}", response);
        return response;
    }


    //"http://service-provider/echo/"
    @GetMapping("/consumer3/{value}")
    public ResponseData consumer3(@PathVariable String value) {
        ResponseData<String> response = this.consumeFeignClient.findStringById2(value);
        log.info("response： \t {}", response);
        return response;
    }

    @GetMapping(value = "/query")
    public ResponseData query(UserDTO userDTO) {
        ResponseData query = this.testConsumeFeignClient.query(userDTO);
        return query;
    }

    @PostMapping(value = "/query2")
    public ResponseData query2(@RequestBody UserDTO userDTO) {
        ResponseData query = this.testConsumeFeignClient.query2(userDTO);
        return query;
    }

    @Autowired
    private TestBaiduFeignClient testBaiduFeignClient;

    @GetMapping("baidu")
    public String baidu() {
        return this.testBaiduFeignClient.index();
    }

}
