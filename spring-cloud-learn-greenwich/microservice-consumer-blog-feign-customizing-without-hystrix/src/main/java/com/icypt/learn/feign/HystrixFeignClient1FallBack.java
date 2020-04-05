package com.icypt.learn.feign;

import com.icypt.learn.vo.User;
import org.springframework.stereotype.Component;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/10 1:48
 * version：1.0
 * description：
 */
@Component
public class HystrixFeignClient1FallBack implements UserFeignClient1 {
    @Override
    public String getServiceInfo(String serviceId) {
        return "en heng en heng";
    }
}
