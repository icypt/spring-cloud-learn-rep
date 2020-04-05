package com.icypt.learn.feign;

import com.icypt.learn.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/5 22:25
 * version：1.0
 * description：
 */
//如果同时配置了fallback、fallbackFactory则先入fallback，fallback优先级高
@FeignClient(name = "microservice-provider-user", fallbackFactory = UserFeignClientFactory.class)
public interface UserFeignClient {
    /**
     * 注意：坑，没有任何提示报404
     * 1、如果使用了这种方式value = "user/getUser/{id}"，则必须使用@PathVariable("id")这个注解否则请求失败
     * 2、必须指定method
     * @param id
     * @return
     */
    @RequestMapping(value = "user/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id);
}
