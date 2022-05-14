package com.icypt.learn.mapper;

import com.icypt.learn.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    public void createOrder(@Param("order") Order order);
}
