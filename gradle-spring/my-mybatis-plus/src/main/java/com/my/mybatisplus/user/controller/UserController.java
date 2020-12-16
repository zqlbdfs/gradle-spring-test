package com.my.mybatisplus.user.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.my.mybatisplus.user.entity.User;
import com.my.mybatisplus.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author KevinLee
 * @since 2020-12-09
 */
@RestController
@RequestMapping("/user/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @DeleteMapping("user")
    public void delete(@RequestBody List<Integer> userIds) {
        boolean b = userService.removeByIds(userIds);
        return;
    }

    @PostMapping("user")
    public User add(@RequestBody User user) {
        boolean save = userService.save(user);
        return user;
    }

    @PutMapping("user")
    public User update(@RequestBody User user) {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id",user.getId());
        boolean save = userService.update(user, userUpdateWrapper);
        return user;
    }
}
