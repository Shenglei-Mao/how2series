package com.yufu.lcm.eventhook.listener.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RabbitReceiver {
    private final static String QUEUE_NAMEA = "companyA";
    private final static String QUEUE_NAMEB = "companyB";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAMEA, false, false, false, null);
        channel.queueDeclare(QUEUE_NAMEB, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAMEA, true, deliverCallback, consumerTag -> { });
        channel.basicConsume(QUEUE_NAMEB, true, deliverCallback, consumerTag -> { });

    }
}
