package com.icypt.learn.controller;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Account;
import com.icypt.learn.entity.Order;
import com.icypt.learn.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVo create(Order order) {
        order.setOrderCreateTime(new Date());
        boolean flag = orderService.createOrder(order);
        if(flag) {
            return new ResultVo("200", "订单创建成功");
        } else {
            return new ResultVo("500", "订单创建失败");
        }
    }
}
