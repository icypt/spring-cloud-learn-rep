package com.icypt.learn.controller;

import com.icypt.learn.service.MessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private MessageProviderService messageProviderService;

    @GetMapping("/sendMsg")
    public  String sendMsg() {
        messageProviderService.send();
        return "ok";
    }
}
