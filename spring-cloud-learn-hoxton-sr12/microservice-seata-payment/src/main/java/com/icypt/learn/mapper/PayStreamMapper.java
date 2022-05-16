package com.icypt.learn.mapper;

import com.icypt.learn.entity.PayStream;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayStreamMapper {
    public void createPayStream(@Param("payStream") PayStream payStream);
    public void updatePayStream(@Param("payStream") PayStream payStream);
}
