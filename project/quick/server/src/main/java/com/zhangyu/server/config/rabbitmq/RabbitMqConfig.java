package com.zhangyu.server.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbitMq 配置类，该配置类为单Queue测试
 */
@Configuration
public class RabbitMqConfig {

    /**
     * routingKey
     */
    public static final String RABBITMQ_NAME = "Sko";


    /**
     * 注意引用的类型import
     * {@link Queue}
     */
    @Bean
    public Queue sentQueue() {
        return new Queue(RABBITMQ_NAME, true);
    }

    //topic 模式 ------

    //路由键必须是一串字符，用句号（.） 隔开，
    //
    //路由模式必须包含一个 星号（*），主要用于匹配路由键指定位置的一个单词， 井号（#）就表示相当于一个或者多个单词
    public static final String TOPIC_EXCHANGE = "topic_exchange";
    public static final String TOPIC_QUEUE1 = "topic.queue1";
    public static final String TOPIC_QUEUE2 = "topic.queue2";
    public static final String ROUTING_KEY1 = "topic.key1";
    public static final String ROUTING_KEY2 = "topic.#.ko"; //路由器模式

    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * 队列绑定交换机，然后再绑定routingKey
     */
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(topicQueue1()).to(exchange()).with(ROUTING_KEY1);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(topicQueue2()).to(exchange()).with(ROUTING_KEY2);
    }

    //fanout 广播模式

    public static final String FANOUT_QUEUE = "fanout.queue1";
    public static final String FANOUT_QUEUE2 = "fanout.queue2";
    public static final String FANOUT_EXCHANGE = "fanout.exchange";


    @Bean
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE2);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

}
