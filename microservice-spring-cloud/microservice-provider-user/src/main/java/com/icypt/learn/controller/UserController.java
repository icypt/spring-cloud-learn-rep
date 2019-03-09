package com.icypt.learn.controller;

import com.icypt.learn.entity.User;
import com.icypt.learn.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/2/28 23:20
 * version：1.0
 * description：
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id")Long id) {
        Optional<User> oUser = userRepository.findById(id);
        if(oUser.isPresent()) {
            return oUser.get();
        }
        return null;
    }

    @GetMapping("/getMcHomePageUrl")
    public String getMicroHomePageUrl() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("microservice-provider-user", true);
        return instanceInfo.getHomePageUrl();
    }

    @GetMapping("/instancesInfo")
    public Object getMcsInstanceInfo() {
        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-provider-user");
        return instances;
    }

    @GetMapping("/testGetUser")
    public User testGetUser(@RequestBody User user) {
        return user;
    }

    @PostMapping("/testPostUser")
    public User testPostUser(@RequestBody User user) {
        return user;
    }
}
