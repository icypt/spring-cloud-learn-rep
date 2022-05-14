package com.icypt.learn.service.impl;

import com.icypt.learn.entity.Account;
import com.icypt.learn.entity.Order;
import com.icypt.learn.entity.PayStream;
import com.icypt.learn.mapper.OrderMapper;
import com.icypt.learn.service.FeignAccountService;
import com.icypt.learn.service.FeignPaymentService;
import com.icypt.learn.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private FeignAccountService feignAccountService;

    @Resource
    private FeignPaymentService feignPaymentService;

    @Override
    public boolean createOrder(Order order) {
        //1、创建订单，状态为：01，初始化
        order.setOrderStatus("01");
        order.setOrderCreateTime(new Date());
        orderMapper.createOrder(order);
        //2、创建支付流水，状态为：01，初始化
        PayStream payStream = new PayStream();
        payStream.setPayStreamNo("pay_" + System.currentTimeMillis());
        payStream.setPayStreamStatus("01");
        payStream.setOrderId(order.getOrderId());
        payStream.setPayStreamAmt(order.getOrderAmt());
        payStream.setPayStreamCreateTime(new Date());
        //3、减余额
        Account account = new Account();
        account.setAccountId(order.getAccountId());
        account.setAccountBalance(new BigDecimal(account.getAccountBalance()).subtract(new BigDecimal(order.getOrderAmt())).toString());
        feignAccountService.updateAccountBalance(account);
        //4、模拟支付

        //5、支付成功，更新流水状态

        //6、支付成功，更新订单状态
        return true;
    }
}
