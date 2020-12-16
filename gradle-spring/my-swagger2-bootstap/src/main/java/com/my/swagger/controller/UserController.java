package com.my.swagger.controller;

import com.google.common.base.Preconditions;
import com.my.swagger.entity.User;
import com.my.swagger.validate.group.UpdateUserGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String delete() {
        return "delete user";
    }


    @PostMapping("add")
    public String add(@RequestBody @Validated User user) {

        Preconditions.checkNotNull(user.getProduct(),"请传入产品信息");

        return "add user success";
    }

    @PostMapping("update")
    public String update(@RequestBody @Validated(UpdateUserGroup.class) User user) {
        return "add user success";
    }
}
