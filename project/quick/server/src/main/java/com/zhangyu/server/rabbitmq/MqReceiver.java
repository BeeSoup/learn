    package com.zhangyu.server.rabbitmq;

    import org.springframework.amqp.rabbit.annotation.RabbitHandler;
    import org.springframework.amqp.rabbit.annotation.RabbitListener;
    import org.springframework.stereotype.Component;

    //@Component
    @RabbitListener(queues = {
            "sent"
    })
    public class MqReceiver {

        @RabbitHandler
        public void receiver(String context) {
            System.out.printf("[text] --receiver : %s\n", context);
        }
    }
