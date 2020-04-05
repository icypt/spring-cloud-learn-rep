package com.icypt.learn.Controller;

import com.icypt.learn.feign.UserFeignClient;
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

    @RequestMapping("simple/{id}")
    public User simple(@PathVariable("id")Long id) {
       return userFeignClient.getUser(id);
    }

    /**
     * 如果参数为复杂对象，则feign必须使用post方式传输，不然请求无法成功，此请求无法成功，status：405
     * @param user
     * @return
     */
    @GetMapping("testGetUser")
    public User tesGetUser(User user) {
        return userFeignClient.testGetUser(user);
    }

    /**
     * 传递复杂对象正常请求
     * @param user
     * @return
     */
    @GetMapping("testPostUser")
    public User testPostUser( User user) {
        return userFeignClient.testPostUser(user);
    }
}
