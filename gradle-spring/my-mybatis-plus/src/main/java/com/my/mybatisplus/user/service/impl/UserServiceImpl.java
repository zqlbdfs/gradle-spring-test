package com.my.mybatisplus.user.service.impl;

import com.my.mybatisplus.user.entity.User;
import com.my.mybatisplus.user.mapper.UserMapper;
import com.my.mybatisplus.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KevinLee
 * @since 2020-12-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
