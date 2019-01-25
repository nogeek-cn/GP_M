package com.darian.kafkademo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class KafkaProducerController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/message/send/{topic}")
    public boolean sendMessage(
            @PathVariable String topic,
            @RequestParam String message) {
        kafkaTemplate.send(topic, message);
        return true;
    }

}
