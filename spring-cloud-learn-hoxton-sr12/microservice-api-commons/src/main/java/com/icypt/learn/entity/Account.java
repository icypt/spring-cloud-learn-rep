package com.icypt.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
@NoArgsConstructor
public class Account implements Serializable {
    private Long accountId;
    private String accountName;
    private String accountBalance;
}
