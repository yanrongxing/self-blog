package com.better.xing.service.impl;

import com.better.xing.common.util.BeanUtil;
import com.better.xing.controller.response.AllBlogRep;
import com.better.xing.mongo.entity.BlogModel;
import com.better.xing.mongo.entity.TypeModel;
import com.better.xing.mongo.repository.BlogRepository;
import com.better.xing.mongo.repository.TypeRepository;
import com.better.xing.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 21:33
 */
@Service
@Transactional
public class BlogServiceImpl implements IBlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public List<AllBlogRep> findAllBlog() {
        List<AllBlogRep> allBlogReps = new ArrayList<>();
        List<BlogModel> all = blogRepository.findAll();
        List<TypeModel> typeModels = typeRepository.findAll();
        all.forEach(blogModel -> {
            AllBlogRep allBlogRep = new AllBlogRep();
            BeanUtils.copyProperties(blogModel,allBlogRep);
            Stream<TypeModel> typeModelStream = typeModels.stream().filter(typeModel -> typeModel.getId().equals(blogModel.getType()));
            allBlogRep.setTypeModel(typeModelStream.findFirst().get());
            allBlogReps.add(allBlogRep);
        });
        return allBlogReps;
    }

    @Override
    public BlogModel findById(String id) {
        Optional<BlogModel> byId = blogRepository.findById(id);
        return byId.get();
    }

    @Override
    public void insertBlog(BlogModel blogModel) {
        Date date = new Date();
        blogModel.setCreateTime(date);
        blogModel.setUpdateTime(date);
        blogRepository.save(blogModel);
    }

    @Override
    public void updateBlog(BlogModel blogModel){
        Optional<BlogModel> byId = blogRepository.findById(blogModel.getId());
        BlogModel blogModelDb = byId.get();
        BeanUtil.copyPropertiesIgNull(blogModel,blogModelDb);
        blogModelDb.setUpdateTime(new Date());
        blogRepository.save(blogModelDb);
    }

    @Override
    public void deleteBlog(String id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<TypeModel> findAllType() {
        return typeRepository.findAll();
    }

    @Override
    public List<BlogModel> findBlogModelsByType(String typeId) {
        return blogRepository.findBlogModelsByTypeEquals(typeId);
    }
}
