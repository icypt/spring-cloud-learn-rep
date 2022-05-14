package com.icypt.learn.service.impl;

import com.icypt.learn.entity.Account;
import com.icypt.learn.mapper.AccountMapper;
import com.icypt.learn.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public boolean updateAccountBalance(Account account) {
        try {
            accountMapper.updateAccountBalance(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
