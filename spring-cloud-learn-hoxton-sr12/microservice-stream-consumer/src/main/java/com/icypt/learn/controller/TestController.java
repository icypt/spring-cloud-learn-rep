package com.icypt.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public  void getMessage(Message<String> message) {
        log.info("消费者：" + serverPort + "\t" + "消费内容：" + message.getPayload());
    }
}
