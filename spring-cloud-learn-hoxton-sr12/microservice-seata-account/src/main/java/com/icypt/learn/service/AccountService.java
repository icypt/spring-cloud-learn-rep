package com.icypt.learn.service;

import com.icypt.learn.entity.Account;

public interface AccountService {
    public boolean updateAccountBalance(Account account);

    public Account getAccount(Long accountId);
}
