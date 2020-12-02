package com.my.web.template;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @ClassName MyTemplate.java
 * @Description TODO
 * @createTime 2020年11月30日 16:50:00
 */
@Component
public class MyTemplate {

    public Map doProcess(ICallable iCallable){
        Map map = new HashMap();
        try {
            iCallable.doProcess();
        }catch (Exception ex){
            map.put("msg",ex.getMessage());
            map.put("success",false);
            return map;
        }
        map.put("success",true);
        return  map;

    }


}
