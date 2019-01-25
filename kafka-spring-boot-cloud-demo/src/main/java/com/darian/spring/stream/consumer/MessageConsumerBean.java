//package com.darian.spring.stream.consumer;
//
//import com.darian.spring.stream.message.DarianMessageSink;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.messaging.SubscribableChannel;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//@EnableBinding({Sink.class, DarianMessageSink.class})
//public class MessageConsumerBean {
//
//    @Autowired
//    @Qualifier(Sink.INPUT)
//    private SubscribableChannel subscribableChannel;
//
//    @Autowired
//    private Sink sink;
//
//    // 当字段注入完成以后的回调
//    // 一定是要一个异步的监听
//    @PostConstruct
//    public void init() {
//        // 实现异步回调
//        subscribableChannel.subscribe(message -> {
//            System.out.println("Stream=subscribableChannel=异步回调：" + message.getPayload());
//        });
//    }
//
//
//    @Autowired
//    @Qualifier(DarianMessageSink.Name)
//    private SubscribableChannel darianSubscribableChannel;
//
//    @Autowired
//    private DarianMessageSink darianMessageSink;
//
//    // 当字段注入完成以后的回调
//    // 一定是要一个异步的监听
//    @PostConstruct
//    public void initdarian() {
//        // 实现异步回调
//        darianSubscribableChannel.subscribe(message -> {
//            System.out.println("Stream=darianSubscribableChannel=异步回调：" + message.getPayload());
//        });
//    }
//
//
//}