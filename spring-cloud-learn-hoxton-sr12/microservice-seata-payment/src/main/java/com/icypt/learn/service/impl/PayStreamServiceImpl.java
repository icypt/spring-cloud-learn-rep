package com.icypt.learn.service.impl;

import com.icypt.learn.entity.PayStream;
import com.icypt.learn.mapper.PayStreamMapper;
import com.icypt.learn.service.PayStreamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayStreamServiceImpl implements PayStreamService {

    @Resource
    private PayStreamMapper payStreamMapper;

    @Override
    public boolean createPayStream(PayStream payStream) {
        payStreamMapper.createPayStream(payStream);
        return true;
    }

    @Override
    public boolean updatePayStream(PayStream payStream) {
        payStreamMapper.updatePayStream(payStream);
        return true;
    }
}
