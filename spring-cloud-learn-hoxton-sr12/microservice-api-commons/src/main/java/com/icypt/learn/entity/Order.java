package com.icypt.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
public class Order implements Serializable {
    private Long orderId;
    private String orderNo;
    private String orderAmt;
    private Date orderCreateTime;
    private String orderStatus;
    private Long accountId;
}
