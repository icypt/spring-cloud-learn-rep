package com.icypt.learn.service;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Account;
import com.icypt.learn.entity.PayStream;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "microservice-seata-payment")
public interface FeignPaymentService {

    @PostMapping("/payStream/create")
    public ResultVo create(PayStream payStream);

    @PostMapping("/payStream/update")
    public ResultVo update(PayStream payStream);

    @PostMapping("/payStream/pay")
    public ResultVo pay(PayStream payStream);
}
