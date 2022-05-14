package com.icypt.learn.service;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "microservice-seata-account")
public interface FeignAccountService {

    @PostMapping("/updateBalance")
    public ResultVo updateAccountBalance(Account account);
}
