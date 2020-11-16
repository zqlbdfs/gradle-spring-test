package com.my.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * @author kevin
 * @ClassName TestUser.java
 * @Description TODO
 * @createTime 2020年11月16日 10:48:00
 */
@Document(indexName = "test-user",type = "user")
@Data
public class User {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String userName;

    @Field(type = FieldType.Integer)
    private int age;

    private Dept dept;

    private List<String> interests;
}
