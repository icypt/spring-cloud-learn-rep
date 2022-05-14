package com.icypt.learn.mapper;

import com.icypt.learn.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
    public void updateAccountBalance(@Param("account") Account account);
}
