package com.icypt.learn.controller;

import com.icypt.learn.api.PaymentFeignService;
import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Payment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping("/payment/create")
    public ResultVo create(Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/payment/get/{id}")
    public ResultVo get(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }

    @GetMapping("/payment/timeout")
    public String timeout() {
        return paymentFeignService.timeout();
    }
}
