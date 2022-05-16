package com.icypt.learn.service;

import com.icypt.learn.entity.PayStream;

public interface PayStreamService {
    public boolean createPayStream(PayStream payStream);

    public boolean updatePayStream(PayStream payStream);
}
