package com.icypt.learn.controller;

import com.icypt.learn.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService  paymentService;

    @GetMapping("/getOk/{id}")
    public String getOk(@PathVariable String id) {
        return paymentService.getOk(id);
    }

    @GetMapping("/getTimeout/{id}")
    public String getTimeout(@PathVariable String id) {
        return paymentService.getTimeout(id);
    }

    //========以下为服务熔断测试代码
    @GetMapping("/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
