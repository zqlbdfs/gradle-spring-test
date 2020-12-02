package com.my.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @ClassName ExcDeal.java
 * @Description TODO
 * @createTime 2020年11月30日 16:46:00
 */

@ControllerAdvice
public class ExcDeal {

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleAndReturnData(HttpServletRequest requset, HttpServletResponse response, Exception ex) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (ex instanceof RuntimeException) {
            resultMap.put("msg", ex.getMessage());
            resultMap.put("error-code", 504);
        }
        return resultMap;
    }
}
