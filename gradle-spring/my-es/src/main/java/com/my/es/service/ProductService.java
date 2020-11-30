package com.my.es.service;

import com.my.es.dao.ProductRepository;
import com.my.es.entity.Product;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.ConstantScoreQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * @author kevin
 * @ClassName ProductService.java
 * @Description TODO
 * @createTime 2020年11月17日 09:26:00
 */
@Service
public class ProductService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ProductRepository productRepository;

    public Product add(Product product) {
        Product index = productRepository.index(product);
        return index;
    }

    public void query(Product product) {

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should();
        ConstantScoreQueryBuilder constantScoreQueryBuilder = new ConstantScoreQueryBuilder(boolQuery());



    }
}
