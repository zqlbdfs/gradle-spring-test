package com.my.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author kevin
 * @ClassName Product.java
 * @Description TODO
 * @createTime 2020年11月17日 09:23:00
 */
@Document(indexName = "test-product",type = "product")
@Data
public class Product {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String productId;

    @Field(type = FieldType.Double)
    private Double price;
}
