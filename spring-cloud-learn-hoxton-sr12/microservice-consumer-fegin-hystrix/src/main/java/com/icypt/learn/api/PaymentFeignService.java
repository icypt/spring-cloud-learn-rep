package com.icypt.learn.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "microservice-provider-with-hystrix", fallback = PaymentHystrixService.class)
public interface PaymentFeignService {



    @GetMapping("/payment/getOk/{id}")
    public String getOk(@PathVariable("id") String id);

    @GetMapping("/payment/getTimeout/{id}")
    public String getTimeout(@PathVariable("id") String id);


}
