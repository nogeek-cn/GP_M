package com.darian.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Kafka 的消费者监听
 * <br>Darian
 **/
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "${kafka.topic.test}")
    public void onMessage(String message) {
        System.out.println("Kafka 消费者监听器，接收到消息：" + message);
    }

}
