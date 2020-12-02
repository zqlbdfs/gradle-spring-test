package com.my.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author kevin
 * @ClassName Product.java
 * @Description TODO
 * @createTime 2020年12月02日 11:53:00
 */
@ApiModel(value = "产品实体")
@Data
public class Product extends BaseBean {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "名称",required = true )
    private String name;
    @ApiModelProperty(value = "数量")
    private Integer num;
    @ApiModelProperty(value = "创建时间",dataType = "date")
    private Date createTime;
    @ApiModelProperty(value = "我的用户")
    private User user;
}
