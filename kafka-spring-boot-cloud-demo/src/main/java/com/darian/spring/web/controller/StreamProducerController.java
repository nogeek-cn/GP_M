//package com.darian.spring.web.controller;
//
//import com.darian.spring.stream.producer.MessageProducerBean;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class StreamProducerController {
//
//    private final MessageProducerBean messageProducerBean;
//
//    /**
//     * 通过 {@link MessageProducerBean} 发送
//     * <br>Darian
//     **/
//    @GetMapping("/message/send")
//    public boolean send(@RequestParam String message) {
//        messageProducerBean.send(message);
//        return true;
//    }
//
//    @GetMapping("/message/sendToDarian2")
//    public boolean sendToDarian2(@RequestParam String message){
//        messageProducerBean.sendToDarian(message);
//        return true;
//    }
//
//
//}
