package com.darian.spring.boot2.x;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.SubscribableChannel;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;

public class StreamProducerControllerAPI {

    @Autowired
    private SimpleMessageReceiver simpleMessageReceiver;

    @PostConstruct
    public void init() {  // 接口编程
        // 获取 SubscribableChannel
        SubscribableChannel subscribableChannel = simpleMessageReceiver.gupao();
        subscribableChannel.subscribe(message -> {
            MessageHeaders headers = message.getHeaders();
            String encoding = (String) headers.get("charset-encoding");
            String text = (String) headers.get("content-type");
            byte[] content = (byte[]) message.getPayload();
            try {
                System.out.println("接受到消息：" + new String(content, encoding));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }

    @StreamListener("gupao2018")  // Spring Cloud Stream 注解驱动
    public void onMessage(byte[] data) {
        System.out.println("onMessage(byte[]): " + new String(data));
    }

    @StreamListener("gupao2018")  // Spring Cloud Stream 注解驱动
    public void onMessage(String data) {
        System.out.println("onMessage(String) : " + data);
    }

    @StreamListener("gupao2018") // Spring Cloud Stream 注解驱动
    public void onMessage2(String data2) {
        System.out.println("onMessage2(String) : " + data2);
    }

    @ServiceActivator(inputChannel = "gupao2018") // Spring Integration 注解驱动
    public void onServiceActivator(String data) {
        System.out.println("onServiceActivator(String) : " + data);
    }


}
