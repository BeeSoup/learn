package com.zhangyu.quick.controller;

import com.zhangyu.quick.mq.MqSent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {


    @Autowired
    MqSent mqSent;


    @PostMapping(value = "sentMq")
    public String sentMq(@RequestParam String msg) {

        mqSent.sent(msg);

        return "OK";
    }

    @PostMapping(value = "topicSentMq")
    public String topicSentMq(@RequestParam String msg) {

        mqSent.topicSent(msg);

        return "OK";
    }

    //[text] --fanoutReceiver2 : 2020-05-29T16:04:49.967 -- 开始测试fanout
    //[text] --fanoutReceiver : 2020-05-29T16:04:49.967 -- 开始测试fanout
    @PostMapping(value = "fanoutSentMq")
    public String fanoutSentMq(@RequestParam String msg) {

        mqSent.fanoutSent(msg);

        return "OK";
    }
}
