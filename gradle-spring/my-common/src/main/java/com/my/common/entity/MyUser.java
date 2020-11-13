package com.my.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kevin
 * @ClassName MyUser.java
 * @Description TODO
 * @createTime 2020年11月11日 15:27:00
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {

    private String id;
}
