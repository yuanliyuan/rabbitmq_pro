package com.yl.demo1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: 袁黎
 * @Date: 2021-01-06 17:19
 **/
public class RabbitProducer {

    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = " routingkey_demo";


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constant.IP_ADDRESS);
        factory.setPort(Constant.PORT);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = factory.newConnection().createChannel();

        // 创建一个type="direct",持久化,非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        // 创建一个持久化,非排他的,非自动化删除的队列
        channel.queueDeclare(Constant.QUEUE_NAME, true, false, false, null);
        // 将交换器与队列通过路由器绑定
        channel.queueBind(Constant.QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        String message = "hello world";
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        channel.close();
        connection.close();
    }
}
