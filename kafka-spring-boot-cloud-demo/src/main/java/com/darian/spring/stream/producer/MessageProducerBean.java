//package com.darian.spring.stream.producer;
//
//import com.darian.spring.stream.message.DarianMessageSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Component;
//
///**
// * <br> 消息生产者
// * <br>Darian
// **/
//@Component
//@EnableBinding({Source.class,DarianMessageSource.class})
//public class MessageProducerBean {
//
//    @Autowired
//    @Qualifier(Source.OUTPUT) // Bean 名称
//    private MessageChannel messageChannel;
//
//    @Autowired
//    private Source source;
//
//    @Autowired
//    private DarianMessageSource darianMessageSource;
//
//    @Autowired
//    @Qualifier(DarianMessageSource.Name) // bean 名称
//    private MessageChannel darianMessageChannel;
//
//
//    /**
//     * 发送消息
//     * <br>Darian
//     **/
//    public void send(String message) {
//        // 通过消息管道发送消息
////        messageChannel.send(MessageBuilder.withPayload(message).build());
//        source.output().send(MessageBuilder.withPayload(message).build());
//    }
//
//    /**
//     * 发送消息到 darin
//     * <br>Darian
//     **/
//    public void sendToDarian(String message) {
//        // 通过消息管道发送消息
//        darianMessageChannel.send(MessageBuilder.withPayload(message).build());
//    }
//}