package com.icypt.learn.service;

import com.icypt.learn.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {


    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
