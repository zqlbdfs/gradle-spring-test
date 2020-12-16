package com.my;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//配置mapper 包路径
@MapperScan("com.my.mybatisplus.user.mapper")
public class MyBatisMain {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisMain.class,args);
    }
}
