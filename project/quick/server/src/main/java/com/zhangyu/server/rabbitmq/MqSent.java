package com.zhangyu.server.rabbitmq;


import com.zhangyu.server.config.rabbitmq.RabbitMqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MqSent {


    private AmqpTemplate amqpTemplate;

    @Autowired
    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sent(String msg) {
        String context = "sent--" + LocalDateTime.now() + " -- " + msg;
        System.out.printf(" [test] sent: %s \n", context);
        amqpTemplate.convertAndSend(RabbitMqConfig.RABBITMQ_NAME, context);
    }

    public void topicSent(String msg) {


        //        CorrelationData correlationData = new CorrelationData();
        //        correlationData.setId(order.getMessageId()); //消息唯一id

        String context = LocalDateTime.now() + " -- " + msg;
        String routingKey = "topic.key1";
        String routingKey2 = "topic.googleEmail.ko";
        System.out.printf(" [%s]->(%s) sent: %s \n", RabbitMqConfig.TOPIC_EXCHANGE, routingKey, context);
        amqpTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE, routingKey, context);
        System.out.printf(" [%s]->(%s) sent: %s \n", RabbitMqConfig.TOPIC_EXCHANGE, routingKey2, context);
        amqpTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE, routingKey2, context + "--toc2");
    }

    public void fanoutSent(String msg) {

        String context = LocalDateTime.now() + " -- " + msg;

        System.out.printf(" [%s] sent: %s \n", RabbitMqConfig.FANOUT_EXCHANGE, context);

        amqpTemplate.convertAndSend(RabbitMqConfig.FANOUT_EXCHANGE, "", context);
    }

    // [topic_exchange]->(topic.key1) sent: 2020-04-29T15:41:35.075 -- 开始测试topic
    // [topic_exchange]->(topic.googleEmail.ko) sent: 2020-04-29T15:41:35.075 -- 开始测试topic
}
