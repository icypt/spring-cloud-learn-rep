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
public class HystrixFeignClientFallBack implements UserFeignClient {
    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setName("进入短路器Ballback method-->" + id);
        return user;
    }
}
