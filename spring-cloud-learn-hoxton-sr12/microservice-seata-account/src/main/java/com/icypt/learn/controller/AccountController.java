package com.icypt.learn.controller;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Account;
import com.icypt.learn.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/updateBalance")
    public ResultVo updateAccountBalance(@RequestBody Account account) {
        boolean flag = accountService.updateAccountBalance(account);
        if(flag) {
            return new ResultVo("200", "余额更新成功");
        } else {
            return new ResultVo("500", "余额更新失败");
        }
    }

    @GetMapping("/get/{accountId}")
    public ResultVo get(@PathVariable("accountId") Long accountId) {
       return new ResultVo<>("200", "", accountService.getAccount(accountId));
    }
}
