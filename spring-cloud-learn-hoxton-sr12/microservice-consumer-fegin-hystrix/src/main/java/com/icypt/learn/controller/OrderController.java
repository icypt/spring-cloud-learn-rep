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



    @GetMapping("/payment/getOk/{id}")
    public String getOk(@PathVariable("id") String id) {
        return paymentFeignService.getOk(id);
    }

    @GetMapping("/payment/getTimeout/{id}")
    public String getTimeout(@PathVariable("id") String id) {
        return paymentFeignService.getTimeout(id);
    }

}
