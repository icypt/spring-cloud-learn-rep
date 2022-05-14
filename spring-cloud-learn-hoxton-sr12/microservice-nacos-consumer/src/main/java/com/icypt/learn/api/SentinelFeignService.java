package com.icypt.learn.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(value = "microservice-nacos-provider", fallback = SentinelFeignServiceFallback.class)
public interface SentinelFeignService {

    @GetMapping("/payment/testException/{id}")
    public  String testException(@PathVariable(value = "id") String id);
}
