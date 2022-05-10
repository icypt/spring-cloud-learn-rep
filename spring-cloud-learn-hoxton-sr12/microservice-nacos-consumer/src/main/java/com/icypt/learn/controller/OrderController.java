package com.icypt.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Value("${service.url}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getInfo/{id}")
    public  String getInfo(@PathVariable String id) {
        return restTemplate.getForObject(serviceUrl+"/payment/getInfo/" + id, String.class);
    }
}
