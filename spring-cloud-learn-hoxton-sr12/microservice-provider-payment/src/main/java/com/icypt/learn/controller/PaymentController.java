package com.icypt.learn.controller;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.dao.PaymentDao;
import com.icypt.learn.entity.Payment;
import com.icypt.learn.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @PostMapping("/create")
    public ResultVo create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("=====插入成功=======");
        if(result > 0) {
            return new ResultVo("200", "插入数据成功",result);
        } else {
            return new ResultVo("444", "插入数据失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public ResultVo get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if(null != payment) {
            return new ResultVo("200", "查询成功", payment);
        } else {
            return new ResultVo("444", "没记录", null);
        }
    }
}
