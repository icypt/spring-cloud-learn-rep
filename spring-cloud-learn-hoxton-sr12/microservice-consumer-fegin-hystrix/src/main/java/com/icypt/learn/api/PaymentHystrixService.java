package com.icypt.learn.api;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixService implements PaymentFeignService{
    @Override
    public String getOk(String id) {
        return Thread.currentThread().getName() + "\t" + "系统超时或处理异常\tgetOk\to(╥﹏╥)o";
    }

    @Override
    public String getTimeout(String id) {
        return Thread.currentThread().getName() + "\t" + "系统超时或处理异常\tgetTimeout\to(╥﹏╥)o";
    }
}
