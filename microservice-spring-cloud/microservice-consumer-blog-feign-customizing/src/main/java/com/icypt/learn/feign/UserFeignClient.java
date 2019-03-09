package com.icypt.learn.feign;

import com.icypt.learn.vo.User;
import config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.Configuration;
import java.util.Optional;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/5 22:25
 * version：1.0
 * description：
 */
@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class)
public interface UserFeignClient {
    @RequestLine("GET user/getUser/{id}")
    public User getUser(@Param("id") Long id);
}
