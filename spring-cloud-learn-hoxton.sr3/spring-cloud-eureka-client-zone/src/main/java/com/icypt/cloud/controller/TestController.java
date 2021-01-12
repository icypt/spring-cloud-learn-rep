package com.icypt.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PlatForm： 冰点IT
 * projectName: 个人博客
 * Author：icypt
 * CreateTime： 2020/4/6 22:58
 * Version：2.0
 * Description：
 * URL: www.icypt.com
 */
@RestController
public class TestController {
    @Value("${zone.name}")
    private String zoneName;

    @GetMapping("/getZoneName")
    public String getZoneName() {
        return zoneName;
    }
}
