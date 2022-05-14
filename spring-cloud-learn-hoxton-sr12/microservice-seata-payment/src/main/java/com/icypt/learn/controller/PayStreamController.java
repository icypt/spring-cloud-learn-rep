package com.icypt.learn.controller;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Order;
import com.icypt.learn.entity.PayStream;
import com.icypt.learn.service.PayStreamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/payStream")
public class PayStreamController {

    @Resource
    private PayStreamService payStreamService;

    @PostMapping("/create")
    public ResultVo create(PayStream payStream) {
        payStream.setPayStreamCreateTime(new Date());
        boolean flag = payStreamService.createPayStream(payStream);
        if(flag) {
            return new ResultVo("200", "支付成功");
        } else {
            return new ResultVo("500", "支付失败");
        }
    }
}
