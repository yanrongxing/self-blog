package com.better.xing.service;

import com.better.xing.controller.response.AllBlogRep;
import com.better.xing.mongo.entity.BlogModel;
import com.better.xing.mongo.entity.TypeModel;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 21:32
 */
public interface IBlogService {

    List<AllBlogRep> findAllBlog();

    BlogModel findById(String id);

    void insertBlog(BlogModel blogModel);

    void updateBlog(BlogModel blogModel);

    void deleteBlog(String id);

    List<TypeModel> findAllType();

    List<BlogModel> findBlogModelsByType(String typeId);
}
