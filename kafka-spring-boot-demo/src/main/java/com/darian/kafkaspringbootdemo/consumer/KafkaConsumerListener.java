package com.darian.kafkaspringbootdemo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Kafka 的消费者监听
 * <br>Darian
 **/
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "${kafka.topic.test}")
    public void onMessageTest(String message) {
        System.out.println("Kafka test 消费者监听器，接收到消息：" + message);
    }

    @KafkaListener(topics = "${kafka.topic.darian}")
    public void onMessageDarian(String message) {
        System.out.println("Kafka darian消费者监听器，接收到消息：" + message);
    }

}
