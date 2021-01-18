package com.yl.demo1;

/**
 * @Author: 袁黎
 * @Date: 2021-01-06 17:19
 **/
public class RabbitProducer {

    private static final String EXCHANGE_NAME = "exchange_demo";
    private static final String ROUTING_KEY = " routingkey_demo";


    /*public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constant.IP_ADDRESS);
        factory.setPort(Constant.PORT);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 创建一个type="direct",持久化,非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        // 创建一个持久化,非排他的,非自动化删除的队列
        *//*
         * 1.queue:队列名词
         * 2.durable:是否持久化,当MQ重启,还在
         * 3.exclusive:是否独占,只能有一个消费者监听这个队列
         * 4.autoDelete:是否自动删除,当没有Consumer时,自动删除掉
         * 5.arguments:参数
         *//*
        channel.queueDeclare(Constant.QUEUE_NAME, true, false, false, null);
        // 将交换器与队列通过路由器绑定
        channel.queueBind(Constant.QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        String message = "hello world";
        *//*
         * 1.exchange:交换机的名称,默认模式下交换机会使用默认的""
         * 2.routingKey:路由名称
         * 3.props:配置信息
         * 4.body:发送消息数据
         *//*
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        channel.close();
        connection.close();
    }*/
}
