package com.icypt.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${project.name}")
    private String projectName;

    @RequestMapping("/getConfig")
    public String getConfig() {
        System.out.println("*******");
        return projectName;
    }
}
