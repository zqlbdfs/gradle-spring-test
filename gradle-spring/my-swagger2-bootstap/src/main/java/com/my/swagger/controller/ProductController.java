package com.my.swagger.controller;

import com.my.swagger.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @ClassName ProductController.java
 * @Description TODO
 * @createTime 2020年12月02日 11:47:00
 */
@RestController
@RequestMapping("product")
@Api(tags = "产品管理")
public class ProductController {

    @ApiOperation(value = "新增产品", notes = "新增产品")
    @PostMapping("add")
    public Product add(@RequestBody Product product) {
        return product;
    }
}
