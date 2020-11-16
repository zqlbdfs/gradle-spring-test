package com.my.es.dao;

import com.my.es.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kevin
 * @ClassName UserRepository.java
 * @Description TODO
 * @createTime 2020年11月16日 10:55:00
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User,String> {
}
