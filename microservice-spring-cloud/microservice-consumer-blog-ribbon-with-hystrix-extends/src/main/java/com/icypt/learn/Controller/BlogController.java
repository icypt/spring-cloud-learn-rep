package com.icypt.learn.Controller;

import com.icypt.learn.vo.User;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/1 0:34
 * version：1.0
 * description：
 */
@RestController
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("simple/{id}")
    @HystrixCommand(fallbackMethod = "userFallBack")
    public User simple(@PathVariable("id")Long id) {
       return restTemplate.getForObject("http://microservice-provider-user/user/getUser/" + id, User.class);
    }

    /**
     * 此方法为短路器的回掉方法，参数的类型，返回值的类型必须与@HystrixCommand对应的方法保持一致，否则无法回调成功报500
     * @param id
     * @return
     */
    public User userFallBack(Long id) {
        User user = new User();
        user.setName("已进入短路器FallBackMethod-->" + id);
        return user;
    }
}
