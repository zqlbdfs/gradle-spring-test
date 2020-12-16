package com.my.mybatisplus.gen;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 基础实体类
 * @Author KevinLee
 * @Date 2020/12/9 13:51
 */
@Data
public class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private String isDel;

    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
}
