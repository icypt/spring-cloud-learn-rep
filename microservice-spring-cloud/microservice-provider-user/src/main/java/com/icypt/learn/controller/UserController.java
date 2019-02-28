package com.icypt.learn.controller;

import com.icypt.learn.entity.User;
import com.icypt.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id")Long id) {
        Optional<User> oUser = userRepository.findById(id);
        if(oUser.isPresent()) {
            return oUser.get();
        }
        return null;
    }
}
