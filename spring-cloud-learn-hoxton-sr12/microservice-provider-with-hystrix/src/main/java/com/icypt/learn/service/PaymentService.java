package com.icypt.learn.service;

import com.icypt.learn.entity.Payment;

public interface PaymentService {


   public String getOk(String id);

   public String getTimeout(String id);

   public String paymentCircuitBreaker(Integer id);
}
