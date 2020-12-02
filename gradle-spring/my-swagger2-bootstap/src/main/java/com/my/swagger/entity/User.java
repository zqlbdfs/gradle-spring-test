package com.my.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kevin
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年12月02日 13:30:00
 */
@ApiModel(value = "用户实体")
@Data
public class User {
    @ApiModelProperty(value = "用户名称",required = true)
    private String username;
}
