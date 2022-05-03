package com.icypt.learn.api;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("microservice-provider-register-multiple")
public interface PaymentFeignService {

    @PostMapping("/payment/create")
    public ResultVo create(Payment payment);

    @GetMapping("/payment/get/{id}")
    public ResultVo get(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public String timeout();
}
