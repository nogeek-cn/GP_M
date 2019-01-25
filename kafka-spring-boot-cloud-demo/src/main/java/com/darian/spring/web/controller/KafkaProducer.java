//package com.darian.spring.web.controller;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class KafkaProducer {
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    /**
//     * 通过 KafkaTemplete 发送
//     * <br>Darian
//     **/
//    @PostMapping("/message/send/{topic}")
//    public boolean sendMessage(
//            @PathVariable String topic,
//            @RequestParam String message) {
//        kafkaTemplate.send(topic, message);
//        return true;
//    }
//
//}
