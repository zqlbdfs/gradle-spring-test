package com.my.es.service;

import com.my.es.dao.UserRepository;
import com.my.es.entity.User;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

/**
 * @author kevin
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年11月16日 10:58:00
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add(User user) {
        User res = userRepository.index(user);
        return;
    }

    public void update(User user) {
        User res = userRepository.index(user);
        return;
    }


    /**
     * @param
     * @description 分页查询
     * @author kevin
     */
    public void page(User user) {
        //查询条件
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("userName", user.getUserName()));
        boolQueryBuilder.should(QueryBuilders.termQuery("deptName.keyword", "测试部门"));
        //排序
        FieldSortBuilder sortBuilder = SortBuilders.fieldSort("age").order(SortOrder.ASC);
        //构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder)
                .withSort(sortBuilder)
                //分页
                .withPageable(PageRequest.of(1, 10));




        Page<User> search = userRepository.search(nativeSearchQueryBuilder.build());
        return;
    }


    /**
     * @param
     * @description 普通查询
     * @author kevin
     */
    public void query(User user) {
        //查询条件
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("userName", user.getUserName()));
        boolQueryBuilder.should(QueryBuilders.termQuery("deptName.keyword", "测试部门"));

        Iterable<User> search = userRepository.search(boolQueryBuilder);
        //如果需要排序，可以考虑查询完了使用java 来排序

        return;
    }
}
