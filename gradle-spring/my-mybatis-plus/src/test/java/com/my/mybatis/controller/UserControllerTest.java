package com.my.mybatis.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.mybatisplus.user.entity.User;
import com.my.mybatisplus.user.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //开启mock
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IUserService userService;

    @Before
    public void initData() {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            User user = new User();
            user.setName("这是测试数据" + i);
            user.setAge(i);
            userList.add(user);
        }
        userService.saveOrUpdateBatch(userList);
    }

    @After
    public void clearData() {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            User user = new User();
            user.setName("这是测试数据" + i);
            user.setAge(i);
            userList.add(user);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "这是测试数据");
        userService.remove(queryWrapper);
    }

    /*
     * @Description: 增加用户测试
     * @Author: KevinLee
     * @Date: 2020/12/9 11:16
     * @return: void
     **/
    @Test
    public void addTest() throws Exception {
        User user = new User();
        user.setName("这是测试数据add");
        String userJson = JSONObject.toJSONString(user);
        //POST 请求
        String uri = "/user/user/user";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        //断言验证正确性
        Assert.isTrue(StringUtils.isNotBlank(mvcResult.getResponse().getContentAsString()), "添加用户失败");
        User dbUser = JSONObject.parseObject(mvcResult.getResponse().getContentAsString(), User.class);
        Assert.isTrue(dbUser.getId() > 0, "添加用户失败");
    }


    /*
     * @Description: 修改用户测试
     * @Author: KevinLee
     * @Date: 2020/12/9 11:16
     * @return: void
     **/
    @Test
    public void updateTest() throws Exception {
        QueryWrapper<User> queryWrap = new QueryWrapper<>();
        queryWrap.eq("name", "这是测试数据0");
        User user = userService.getOne(queryWrap);
        user.setName("changed");
        String userJson = JSONObject.toJSONString(user);
        //POST 请求
        String uri = "/user/user/user";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        //断言验证正确性
        Assert.isTrue(StringUtils.isNotBlank(mvcResult.getResponse().getContentAsString()), "更新用户失败");
//        User dbUser = JSONObject.parseObject(mvcResult.getResponse().getContentAsString(), User.class);
    }
}
