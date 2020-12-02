package com.my.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevin
 * @ClassName ServiceA.java
 * @Description TODO
 * @createTime 2020年11月30日 16:43:00
 */
@Service
public class ServiceB {

    @Autowired
    private ServiceA serviceA;

    public String test() {
        throw new RuntimeException("this is from B");
//        return "this is serviceA";
    }

    public String test2() {
//        try {
            serviceA.test();
//        }catch (RuntimeException ex){
//            System.out.println("111");
//        }
       return "11";
    }
}
