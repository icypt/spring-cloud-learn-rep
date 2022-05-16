package com.icypt.learn.service;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "microservice-seata-account")
public interface FeignAccountService {

    @PostMapping("/account/updateBalance")
    public ResultVo updateAccountBalance(Account account);

    @GetMapping("/account/get/{accountId}")
    public ResultVo<Account> get(@PathVariable("accountId") Long accountId);
}
