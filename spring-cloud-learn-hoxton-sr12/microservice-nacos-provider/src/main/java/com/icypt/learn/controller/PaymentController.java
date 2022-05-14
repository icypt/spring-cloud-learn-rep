package com.icypt.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getInfo/{id}")
    public  String getInfo(@PathVariable String id) {
        return "nacos provider port:" + serverPort + ",id=" + id;
    }

    @GetMapping("/testException/{id}")
    public  String testException(@PathVariable String id) {
        if(Integer.parseInt(id) == 5) {
            throw new RuntimeException("系统错误");
        }

        if(Integer.parseInt(id) == 10) {
           throw new IllegalArgumentException("参数异常");
        }
        return "正常返回" + "\t" +",id=" + id;
    }
}
