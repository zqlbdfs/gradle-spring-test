package com.my.mybatis.gen;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

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
    private String isDel;
}
