package com.my.es.controller;

import com.my.es.entity.User;
import com.my.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年11月16日 10:56:00
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("add")
    public void add(@RequestBody User user){
        userService.add(user);
    }

}
