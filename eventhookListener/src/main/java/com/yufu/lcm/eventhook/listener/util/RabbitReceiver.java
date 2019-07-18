package com.yufu.lcm.eventhook.listener.util;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RabbitReceiver {
    private final static String QUEUE_NAMEA = "companyA";
    private final static String QUEUE_NAMEB = "companyB";

    public static void main(String[] argv) throws Exception {

//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        factory.setPort(5672);
//        try {
//            Connection connection = factory.newConnection();
//            Channel channel = connection.createChannel();
//
//            channel.queueDeclare(QUEUE_NAMEA, false, false, false, null);
//            channel.queueDeclare(QUEUE_NAMEB, false, false, false, null);
//            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//                String message = new String(delivery.getBody());
//                System.out.println(" [x] Received 5672'" + message + "'");
//            };
//            channel.basicConsume(QUEUE_NAMEA, true, deliverCallback, consumerTag -> { });
//            channel.basicConsume(QUEUE_NAMEB, true, deliverCallback, consumerTag -> { });
//            connection.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        ConnectionFactory factory2 = new ConnectionFactory();
        factory2.setHost("localhost");
        factory2.setPort(5673);
        try {
            Connection connection = factory2.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAMEA, false, false, false, null);
            channel.queueDeclare(QUEUE_NAMEB, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received 5673'" + message + "'");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                System.out.println(delivery.getEnvelope().getDeliveryTag());
            };
            channel.basicConsume(QUEUE_NAMEA, false, deliverCallback, consumerTag -> { });
//            channel.basicConsume(QUEUE_NAMEB, false, deliverCallback, consumerTag -> { });

            boolean autoAck = false;
            channel.basicConsume(QUEUE_NAMEB, autoAck, "a-consumer-tag",
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag,
                                               Envelope envelope,
                                               AMQP.BasicProperties properties,
                                               byte[] body)
                        throws IOException
                    {
                        long deliveryTag = envelope.getDeliveryTag();
                        // positively acknowledge a single delivery, the message will
                        // be discarded
                        String message = new String(body);
                        System.out.println(message);
                        channel.basicAck(deliveryTag, true);
                        System.out.println(deliveryTag);

                    }
                });

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }




//        Thread t1 = new Thread(){
//            @Override
//            public void run(){
//                ConnectionFactory factory = new ConnectionFactory();
//                factory.setHost("localhost");
//                factory.setPort(4000);
//                try {
//                    Connection connection = factory.newConnection();
//                    Channel channel = connection.createChannel();
//
//                    channel.queueDeclare(QUEUE_NAMEA, false, false, false, null);
//                    channel.queueDeclare(QUEUE_NAMEB, false, false, false, null);
//                    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//                    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//                        String message = new String(delivery.getBody(), "UTF-8");
//                        System.out.println(" [x] Received 4000'" + message + "'");
//                    };
//                    channel.basicConsume(QUEUE_NAMEA, true, deliverCallback, consumerTag -> { });
//                    channel.basicConsume(QUEUE_NAMEB, true, deliverCallback, consumerTag -> { });
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        };
//        t1.start();
//
//        Thread t2 = new Thread(){
//            @Override
//            public void run(){
//                ConnectionFactory factory = new ConnectionFactory();
//                factory.setHost("localhost");
//                factory.setPort(4001);
//                try {
//                    Connection connection = factory.newConnection();
//                    Channel channel = connection.createChannel();
//
//                    channel.queueDeclare(QUEUE_NAMEA, false, false, false, null);
//                    channel.queueDeclare(QUEUE_NAMEB, false, false, false, null);
//                    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//                    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//                        String message = new String(delivery.getBody(), "UTF-8");
//                        System.out.println(" [x] Received 4001'" + message + "'");
//                    };
//                    channel.basicConsume(QUEUE_NAMEA, true, deliverCallback, consumerTag -> { });
//                    channel.basicConsume(QUEUE_NAMEB, true, deliverCallback, consumerTag -> { });
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        };
//        t2.start();




//        factory.setHost("localhost");
//        factory.setPort(4000);
//        Connection connection1 = factory.newConnection();
//        Channel channel1 = connection1.createChannel();
//        channel1.queueDeclare(QUEUE_NAMEA, false, false, false, null);
//        channel1.queueDeclare(QUEUE_NAMEB, false, false, false, null);
//        System.out.println(" Connection1 Waiting for messages. To exit press CTRL+C");





//
//        channel1.basicConsume(QUEUE_NAMEA, true, deliverCallback, consumerTag -> { });
//        channel1.basicConsume(QUEUE_NAMEB, true, deliverCallback, consumerTag -> { });

    }
}
