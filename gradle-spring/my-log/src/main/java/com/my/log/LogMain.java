package com.my.log;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kevin
 * @ClassName LogMain.java
 * @Description TODO
 * @createTime 2020年11月30日 10:56:00
 */
@Slf4j
public class LogMain {

    public static void main(String[] args) {

        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is wran");
        log.error("this is error");
    }
}
