package com.my.es.service;

import com.my.es.dao.UserRepository;
import com.my.es.entity.User;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void query(User user) {
        QueryBuilder queryBuild = new BoolQueryBuilder();
//        queryBuild.
//        userRepository.search(queryBuild);
//        User res = userRepository.index(user);
        return;
    }
}
