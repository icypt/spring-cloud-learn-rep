package com.icypt.learn.Controller;

import com.icypt.learn.vo.User;
import com.netflix.discovery.EurekaClient;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("simple/{id}")
    public User simple(@PathVariable("id")Long id) {
       return restTemplate.getForObject("http://microservice-provider-user/user/getUser/" + id, User.class);
    }

    @RequestMapping("testRibbonRule")
    public boolean testRibbionRule() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        System.out.println("***" + serviceInstance.getHost() + "***" + serviceInstance.getPort() + "***" + serviceInstance.getServiceId());
        ServiceInstance serviceInstance1 = loadBalancerClient.choose("microservice-provider-user1");
        System.out.println("***" + serviceInstance1.getHost() + "***" + serviceInstance1.getPort() + "***" + serviceInstance1.getServiceId());
        return true;
    }

    @GetMapping("testRibbonList")
    public Object testRibbonList() {
        //如果接收list则需要写数组，不能用list接收
        //List<User> userList = restTemplate.getForObject("http://microservice-provider-user/user/testListUser", List.class);
        User[] userArray = restTemplate.getForObject("http://microservice-provider-user/user/testListUser",User[].class);
        for(User user : userArray) {
            System.out.println(user.getId() + "***" + user.getName());
        }
        return userArray;
    }
}
