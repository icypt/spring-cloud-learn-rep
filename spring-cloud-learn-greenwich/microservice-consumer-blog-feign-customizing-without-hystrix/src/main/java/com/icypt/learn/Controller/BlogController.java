package com.icypt.learn.Controller;

import com.icypt.learn.feign.UserFeignClient;
import com.icypt.learn.feign.UserFeignClient1;
import com.icypt.learn.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/1 0:34
 * version：1.0
 * description：
 */
@RestController
public class BlogController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private UserFeignClient1 userFeignClient1;

    @RequestMapping("simple/{id}")
    public User simple(@PathVariable("id")Long id) {
       return userFeignClient.getUser(id);
    }

    @GetMapping("getServiceInfo/{serviceId}")
    public String getServiceInfo(@PathVariable String serviceId) {
        return userFeignClient1.getServiceInfo(serviceId);
    }
}
