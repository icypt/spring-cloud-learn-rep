package com.icypt.learn.repository;

import com.icypt.learn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/2/28 23:51
 * version：1.0
 * description：
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
