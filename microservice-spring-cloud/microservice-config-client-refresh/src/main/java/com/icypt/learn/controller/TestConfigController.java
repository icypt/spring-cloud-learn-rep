package com.icypt.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/17 17:24
 * version：1.0
 * description：
 */
@RestController
@RefreshScope
public class TestConfigController {
    @Value("${profile}")
    private String profile;

    @GetMapping("/getProfile")
    public String getProfile() {
        return  profile;
    }
}
