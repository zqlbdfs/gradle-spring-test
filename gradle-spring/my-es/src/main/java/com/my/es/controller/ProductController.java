package com.my.es.controller;

import com.my.es.entity.Product;
import com.my.es.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @ClassName ProductController.java
 * @Description TODO
 * @createTime 2020年11月17日 09:25:00
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("add")
    public Product add(@RequestBody Product product){
        Product add = productService.add(product);
        return add;
    }


    @PostMapping("query")
    public Product query(@RequestBody Product product){
//        productService.query(product);
        return null;
    }
}
