package com.my.web.service;

import org.springframework.stereotype.Service;

/**
 * @author kevin
 * @ClassName ServiceA.java
 * @Description TODO
 * @createTime 2020年11月30日 16:43:00
 */
@Service
public class ServiceA {

    public String test() {

        throw new RuntimeException("this is from A");

//        return "this is serviceA";
    }
}
