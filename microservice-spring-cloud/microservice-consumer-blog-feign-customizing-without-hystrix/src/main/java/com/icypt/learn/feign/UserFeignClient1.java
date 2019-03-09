package com.icypt.learn.feign;

import com.icypt.learn.vo.User;
import config.Configuration1;
import config.Configuration2;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/5 22:25
 * version：1.0
 * description：
 */
@FeignClient(name = "xxx", url = "http://localhost:8761/" , configuration = Configuration2.class, fallback = HystrixFeignClient1FallBack.class)
public interface UserFeignClient1 {
    @RequestLine(value = "GET /eureka/apps/{serviceId}")
    public String getServiceInfo(@Param("serviceId") String serviceId);
}
