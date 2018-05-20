package com.better.xing.mongo.repository;

import com.better.xing.mongo.entity.TagModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 21:03
 */
public interface TagRepository extends MongoRepository<TagModel,String> {
    TagModel findTagModelByTagName(String tagName);
}
