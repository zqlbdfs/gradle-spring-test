package com.my.swagger.util;

import com.alibaba.fastjson.JSONObject;
import com.my.swagger.entity.Product;

/**
 * @author kevin
 * @ClassName RedisUitl.java
 * @Description TODO
 * @createTime 2020年12月03日 15:51:00
 */
public class RedisUtil {

    public static void main(String[] args) {

        Product product = new Product();
        product.setId("123");
        product.setId("测试产品");
        //使用
        RedisUtil.putObject(product);
        Product product1 = RedisUtil.getObject("123", Product.class);
    }
    public static <T> T getObject(String text, Class<T> clazz) {
        String value = "";//TODO get  value from redis
        T t = JSONObject.parseObject(value, clazz);
        return t;
    }
    public static <T> void putObject(T object) {
        String objectJson = JSONObject.toJSONString(object);
        //TODO put到redis中
    }

}
