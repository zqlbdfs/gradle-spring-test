package com.my.web.controller;

import com.my.common.entity.MyUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description 测试类
 * @author kevin
 * @param
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("user")
    public MyUser user(){
        MyUser user = new MyUser();
        user.setId("123");
//        return user;
        return user;
    }
}
