package com.my.swagger.entity;

import com.my.swagger.validate.group.UpdateUserGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author kevin
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年12月02日 13:30:00
 */
@ApiModel(value = "用户实体")
@Data
public class User {

    @NotNull(message = "请传入uesrId",groups = UpdateUserGroup.class)
    private String userId;

    @ApiModelProperty(value = "用户名称", required = true)
    private String username;

    private Integer age;


    private String address;

//    @Valid
//    @NotNull
    private Product product;
}
