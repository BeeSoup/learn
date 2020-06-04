    package com.zhangyu.server.rabbitmq;


    import com.zhangyu.server.config.rabbitmq.RabbitMqConfig;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.amqp.rabbit.annotation.RabbitHandler;
    import org.springframework.amqp.rabbit.annotation.RabbitListener;
    import org.springframework.stereotype.Component;

    @Component
    @Slf4j
    public class MyReceivers {

            // [test] sent: sent--2020-04-29T15:04:58.761 -- 开始测试MQ
            //[text] --MyReceivers : sent--2020-05-29T15:04:58.761 -- 开始测试MQ
            // [test] sent: sent--2020-04-29T15:04:58.938 -- 开始测试MQ
            //[text] --MyReceivers2 : sent--2020-05-29T15:04:58.938 -- 开始测试MQ
            // [test] sent: sent--2020-04-29T15:04:59.299 -- 开始测试MQ
            //[text] --MyReceivers : sent--2020-05-29T15:04:59.299 -- 开始测试MQ
            // [test] sent: sent--2020-04-29T15:04:59.679 -- 开始测试MQ
            //[text] --MyReceivers2 : sent--2020-05-29T15:04:59.679 -- 开始测试MQ
            // [test] sent: sent--2020-04-29T15:05:00.063 -- 开始测试MQ
            //[text] --MyReceivers : sent--2020-05-29T15:05:00.063 -- 开始测试MQ
            // [test] sent: sent--2020-04-29T15:05:00.479 -- 开始测试MQ
            //[text] --MyReceivers2 : sent--2020-05-29T15:05:00.479 -- 开始测试MQ

        @RabbitListener(queues = {
                RabbitMqConfig.RABBITMQ_NAME
        })
        public void receiver(String context) {
            System.out.printf("[text] --MyReceivers : %s\n", context);
        }


        /**
         * 多个监听，只会默认循环接收。
         */
        @RabbitListener(queues = {
                RabbitMqConfig.RABBITMQ_NAME
        })
        public void receiver2(String context) {
            System.out.printf("[text] --MyReceivers2 : %s\n", context);
        }

        /**
         *
         */
        @RabbitListener(queues = {
                RabbitMqConfig.TOPIC_QUEUE1
        })
        public void topicReceiver(String context) {
            System.out.printf("[text] --topicReceiver : %s\n", context);
        }

        /**
         * 路由器模式，都会被匹配到
         */
        @RabbitListener(queues = {
                RabbitMqConfig.TOPIC_QUEUE2
        })
        public void topicReceiver2(String context) {
            System.out.printf("[text] --topicReceiver2 : %s\n", context);
        }
            //[text] --topicReceiver : 2020-04-29T15:41:35.075 -- 开始测试topic
            //[text] --topicReceiver2 : 2020-04-29T15:41:35.075 -- 开始测试topic
            //[text] --topicReceiver2 : 2020-04-29T15:41:35.075 -- 开始测试topic--toc2

        /**
         * 广播模式，都会被匹配到
         */
        @RabbitListener(queues = {
                RabbitMqConfig.FANOUT_QUEUE
        })
        public void fanoutReceiver(String context) {
            System.out.printf("[text] --fanoutReceiver : %s\n", context);
        }

        /**
         * 广播模式，都会被匹配到
         */
        @RabbitListener(queues = {
                RabbitMqConfig.FANOUT_QUEUE2
        })
        public void fanoutReceiver2(String context) {
            System.out.printf("[text] --fanoutReceiver2 : %s\n", context);
        }

    }
