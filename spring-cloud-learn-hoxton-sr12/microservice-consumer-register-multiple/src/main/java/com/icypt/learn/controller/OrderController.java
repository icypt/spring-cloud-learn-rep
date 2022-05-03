package com.icypt.learn.controller;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    public static final String REQ_URL = "http://microservice-provider-register-multiple";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/payment/create")
    public ResultVo create(Payment payment) {
        return restTemplate.postForObject(REQ_URL+"/payment/create", payment, ResultVo.class);
    }

    @GetMapping("/payment/get/{id}")
    public ResultVo get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REQ_URL+"/payment/get/"+id, ResultVo.class);
    }
}
