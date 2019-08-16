package com.darian.kafkaspringbootdemo.web.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@RestController
public class KafkaProducerController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/message/send/{topic}")
    public TopicMessage sendMessage(
            @PathVariable String topic,
            @RequestParam String message) {
        if ((!"darian".equals(topic)) && (!"test".equals(topic))) {
            return new TopicMessage(topic, message, false, "topic【" + topic + "】 不存在");
        }
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, message);

        return new TopicMessage(topic, message, true, "success");
    }


    @AllArgsConstructor
    @Data
    public static class TopicMessage {
        private String topic;
        private String message;
        private boolean send;
        private String errorMessage;
    }

}
