package com.my.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @ClassName ProductController.java
 * @Description TODO
 * @createTime 2020年12月02日 11:47:00
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("delete")
    public String add(){
        return "delete user";
    }
}
