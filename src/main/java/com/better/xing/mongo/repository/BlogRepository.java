package com.better.xing.mongo.repository;

import com.better.xing.mongo.entity.BlogModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 21:03
 */
public interface BlogRepository extends MongoRepository<BlogModel,String> {
    List<BlogModel> findBlogModelsByTypeEquals(String type);
}
