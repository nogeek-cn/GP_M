package com.darian.javakafka.JAVAKafkaAPI;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;


public class KafkaProducerDemo extends Thread {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    private final boolean isAsync;

    public KafkaProducerDemo(String topic, boolean isAsync) {
        // 设置属性
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "192.168.40.128:9092,192.168.40.129:9092,192.168.40.131:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducerDemo");
        properties.put(ProducerConfig.ACKS_CONFIG, "-1");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, MyParitition.class.getName());
        producer = new KafkaProducer<Integer, String>(properties);
        this.topic = topic;
        this.isAsync = isAsync;
    }

    @Override
    public void run() {
        int num = 0;
        while (num < 500000) {
            String message = "message_" + num;
            System.err.println("[producer message]:" + message);
            if (isAsync) { // 异步发送
                producer.send(new ProducerRecord<>(topic,1, message), (recordMetadata, e) -> {
                    if (recordMetadata != null) {
                        System.err.println("[async-offset]:" + recordMetadata.offset() +
                                "->[partition]:" + recordMetadata.partition());
                    }
                });
            } else {  // 同步发送 future / callable
                try {
                    RecordMetadata recordMetadata = producer.send(new ProducerRecord<>(topic, message)).get();
                    System.err.println("[sync-offset]:" + recordMetadata.offset() +
                            "->[partition]:" + recordMetadata.partition());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            num++;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void main(String[] args) {
        new KafkaProducerDemo("testaaa", true).start();
    }
}
