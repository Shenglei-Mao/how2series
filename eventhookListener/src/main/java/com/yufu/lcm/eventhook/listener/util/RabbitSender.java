package com.yufu.lcm.eventhook.listener.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RabbitSender {

    private final static String QUEUE_NAMEA = "companyA";
    private final static String QUEUE_NAMEB = "companyB";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAMEA, false, false, false, null);
            channel.queueDeclare(QUEUE_NAMEB, false, false, false, null);
            String messageA = "Hello World from A!";
            String messageB = "Hello World from B!";
            for (int i = 0; i < 100; i++) {
                channel.basicPublish("", QUEUE_NAMEA, null, messageA.getBytes());
                log.info(" [x] Sent '" + messageA + "'");
                channel.basicPublish("", QUEUE_NAMEB, null, messageB.getBytes());
                log.info(" [x] Sent '" + messageB + "'");
            }
        }
    }
}
