package com.icypt.learn.service.impl;

import com.icypt.learn.entity.Order;
import com.icypt.learn.mapper.OrderMapper;
import com.icypt.learn.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public boolean createOrder(Order order) {
        try {
            orderMapper.createOrder(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
