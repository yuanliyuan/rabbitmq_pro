package com.yl.demo1;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: 袁黎
 * @Date: 2021-01-06 18:22
 **/
public class RabbitConsumer {


    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Address[] addresses = new Address[]{
                new Address(Constant.IP_ADDRESS, Constant.PORT)
        };
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");

        Connection connection = factory.newConnection(addresses);
        final Channel channel = connection.createChannel();
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel) {
            /**
             * 回调方法,当收到消息后,会自动执行该方法
             * @param consumerTag 标识
             * @param envelope 获取一些信息,比如交换机,路由key
             * @param properties 配置信息
             * @param body 数据
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("receive message:" + new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(Constant.QUEUE_NAME, consumer);
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
