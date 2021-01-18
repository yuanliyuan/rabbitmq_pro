package com.yl.spingboot.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

public class DirectReceiverListener {



    @RabbitHandler
    @RabbitListener(queues = "direct_queue")
    public void process(Message message){
        System.out.println("DirectReceiverListener接收到的消息为:" + new String(message.getBody()));
    }

}
