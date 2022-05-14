package com.icypt.learn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.icypt.learn.api.SentinelFeignService;
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
   private SentinelFeignService sentinelFeignService;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getInfo/{id}")
    public  String getInfo(@PathVariable String id) {
        return restTemplate.getForObject(serviceUrl+"/payment/getInfo/" + id, String.class);
    }

    @GetMapping("/testException/{id}")
    @SentinelResource(value = "testException", blockHandler = "testExceptionHandler", fallback = "testExceptionFallback")
    public  String testException(@PathVariable String id) {
        return restTemplate.getForObject(serviceUrl+"/payment/testException/" + id, String.class);
    }

    public  String testExceptionHandler(@PathVariable String id, BlockException blockException) {
        return "testException 限流兜底方法";
    }

    public  String testExceptionFallback(@PathVariable String id, Throwable e) {
        return "testException 系统异常兜底方法" + "\t" + e.getMessage();
    }

    @GetMapping("/testExceptionIgnore/{id}")
    @SentinelResource(value = "testExceptionIgnore", fallback = "testExceptionIgnoreFallback",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public  String testExceptionIgnore(@PathVariable String id) {
        throw new RuntimeException();
    }

    public  String testExceptionIgnoreFallback(@PathVariable String id, Throwable e) {
        return "testExceptionIgnore 系统异常兜底方法 异常忽略测试" + "\t" + e.getMessage();
    }

    @GetMapping("/sentinelFeign/{id}")
    public  String sentinelFeign(@PathVariable String id) {
        return sentinelFeignService.testException(id);
    }


}
