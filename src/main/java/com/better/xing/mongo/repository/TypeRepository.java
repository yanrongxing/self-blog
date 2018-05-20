package com.better.xing.mongo.repository;

import com.better.xing.mongo.entity.TypeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 21:03
 */
public interface TypeRepository extends MongoRepository<TypeModel,String> {
}
