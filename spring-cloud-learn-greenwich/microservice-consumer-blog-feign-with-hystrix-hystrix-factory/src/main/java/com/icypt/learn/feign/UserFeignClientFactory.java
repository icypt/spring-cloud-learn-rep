package com.icypt.learn.feign;

import com.icypt.learn.vo.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/3/10 2:51
 * version：1.0
 * description：
 */
@Component
public class UserFeignClientFactory implements FallbackFactory {

    private static  final Logger LOGGER = LoggerFactory.getLogger(UserFeignClientFactory.class);

    @Override
    public Object create(Throwable throwable) {
        LOGGER.info("UserFeignClientFactory error reason : {}", throwable.getMessage());

        return new UserFeignClient() {
            @Override
            public User getUser(Long id) {
                User user = new User();
                user.setName("fallbackfactory method-->" + id);
                return user;
            }
        };
    }
}
