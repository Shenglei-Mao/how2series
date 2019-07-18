package com.yufu.lcm.eventhook.listener.util;

import java.time.Duration;
import java.util.Properties;
import java.util.Arrays;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@Slf4j
public class SimpleConsumer_2 {
    private final static ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(3);
    public static void main(String[] args) throws Exception {
//        if(args.length == 0){
//            System.out.println("Enter topic name");
//            return;
//        }
//        //Kafka consumer configuration settings
//        String topicName = args[0].toString();

        String topicName = "event_bus";
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test_2");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer",
            "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
            "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer
            <String, String>(props);

        //Kafka Consumer subscribes list of topics here.
        consumer.subscribe(Arrays.asList(topicName));

        //print the topic name
        System.out.println("Subscribed to topic " + topicName);
        int i = 0;

//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records)
//
//                // print the offset,key and value for the consumer records.
//                System.out.printf("Received offset = %d, key = %s, value = %s\n",
//                    record.offset(), record.key(), record.value());
//        }

        Runnable runnable = () -> {
//            Duration duration = Duration.ofSeconds(1);
            Duration duration = Duration.ofMillis(100);
            ConsumerRecords<String, String> records = consumer.poll(duration);
            for (ConsumerRecord<String, String> record : records) {


                System.out.println("The standard event is: " + record.key() + record.value());

            }
            log.info("Poll finished, will poll after 1 seconds. Current consumer is: " +
                consumer.toString());
        };
        scheduledPool.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }
}
