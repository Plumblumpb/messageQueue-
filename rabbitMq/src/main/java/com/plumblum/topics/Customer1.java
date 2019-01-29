package com.plumblum.topics;

import com.rabbitmq.client.*;

import java.io.IOException;


/**
 * @Auther: cpb
 * @Date: 2019/1/24 15:53
 * @Description:
 */
public class Customer1 {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //随机生成队列名称
        String queueName = channel.queueDeclare().getQueue();
        //声明交换机名称和类型
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //绑定插入队列
        channel.queueBind(queueName,EXCHANGE_NAME,"animal");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
