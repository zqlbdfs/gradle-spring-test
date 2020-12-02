package com.my.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kevin
 * @ClassName BaseBean.java
 * @Description TODO
 * @createTime 2020年12月02日 13:29:00
 */
@Data
@ApiModel(value = "基础类")
public class BaseBean {
    @ApiModelProperty(value = "更新时间")
    private String updateTime;
}
