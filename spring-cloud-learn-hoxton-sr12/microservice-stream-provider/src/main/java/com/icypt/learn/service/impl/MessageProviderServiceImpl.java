package com.icypt.learn.service.impl;

import com.icypt.learn.service.MessageProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
@Slf4j
public class MessageProviderServiceImpl implements MessageProviderService {

    @Resource
    private MessageChannel output;

    @Override
    public void send() {
        String msg = UUID.randomUUID().toString();
        log.info("生产者" +  "\t" + "生产内容：" + msg);
        output.send(MessageBuilder.withPayload(msg).build());
    }
}
