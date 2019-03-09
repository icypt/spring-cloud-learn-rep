package com.icypt.learn.vo;


import java.io.Serializable;
import java.util.Date;

/**
 * platform：www.javaroads.com
 * Author：Javaroads_Jun
 * createTime： 2019/2/28 23:21
 * version：1.0
 * description：
 */
public class User implements Serializable{
    private Long id;
    private String name;
    private Integer age;
    private String job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
