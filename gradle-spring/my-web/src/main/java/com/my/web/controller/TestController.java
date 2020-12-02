package com.my.web.controller;

import com.my.common.entity.MyUser;
import com.my.web.service.ServiceA;
import com.my.web.service.ServiceB;
import com.my.web.template.ICallable;
import com.my.web.template.MyTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

/**
 * @param
 * @author kevin
 * @description 测试类
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ServiceA serviceA;
    @Autowired
    private ServiceB serviceB;

    @GetMapping("serviceA")
    public String serviceA() {
        System.out.println("11111");
        String test = serviceA.test();
        return test;
    }

    @GetMapping("service1")
    public String service1() {
        System.out.println("11111");
        String test = serviceB.test2();
        return test;
    }

    @Autowired
    private MyTemplate myTemplate;

    @GetMapping("serviceB")
    public String serviceB() {
         myTemplate.doProcess(new ICallable() {
            @Override
            public void doProcess() {
                String test = serviceA.test();
                System.out.println(test);
            }
        });
return "";
    }


//
//
//    @RequestMapping("hello")
//    public String hello(){
//        return "hello world";
//    }
//
//    @RequestMapping("user")
//    public MyUser user(){
//        MyUser user = new MyUser();
//        user.setId("123");
////        return user;
//        return user;
//    }
}
