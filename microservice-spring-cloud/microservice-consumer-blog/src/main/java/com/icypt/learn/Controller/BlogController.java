package com.icypt.learn.Controller;

import com.icypt.learn.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @RequestMapping("simple/{id}")
    public User simple(@PathVariable("id")Long id) {
       return restTemplate.getForObject(userServicePath  + "user/getUser/" + id, User.class);
    }
}
