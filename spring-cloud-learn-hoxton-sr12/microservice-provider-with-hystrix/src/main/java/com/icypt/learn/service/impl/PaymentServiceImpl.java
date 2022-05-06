package com.icypt.learn.service.impl;

import com.icypt.learn.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@DefaultProperties(defaultFallback = "globalFallbackHandler")
public class PaymentServiceImpl implements PaymentService {


    @Override
    public String getOk(String id) {
        return Thread.currentThread().getName() + "\t" + "id="+id + "\t" + "O(∩_∩)O哈哈~";
    }

    @Override
//    @HystrixCommand(fallbackMethod = "getTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    }
    @HystrixCommand
    public String getTimeout(String id) {
        int a = 10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "\t" + "id="+id + "\t" + "O(∩_∩)O哈哈~";
    }

    public String getTimeoutHandler(String id) {
        return Thread.currentThread().getName() + "\t" + "id="+id + "\t" + "系统超时或运行报错，o(╥﹏╥)o";
    }

    public String globalFallbackHandler( ){
        return Thread.currentThread().getName() + "\t" + "\t" + "全局异常处理\t系统超时或运行报错，o(╥﹏╥)o";
    }

    //============以下为服务熔断测试代码,HystrixCommandProperties
    @HystrixCommand(defaultFallback = "paymentCircuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启短路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后熔断

    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0) {
            throw new RuntimeException("==========id 不能为负数=========");
        }
        String serialNumber = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号为：" + serialNumber;
    }

    public String paymentCircuitBreakerHandler() {
        return "id 不能为负数，请稍后重试" + "\t" + "o(╥﹏╥)o";
    }
}
