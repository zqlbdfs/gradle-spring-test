package com.my.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author kevin
 * @ClassName Dept.java
 * @Description TODO
 * @createTime 2020年11月16日 14:40:00
 */
@Data
@Document(indexName = "test-dept", type = "dept")
public class Dept {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String deptName;

    @Field(type = FieldType.Date)
    private Date createDate;
}
