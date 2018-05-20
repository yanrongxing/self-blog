package com.better.xing.service.impl;

import com.better.xing.mongo.entity.TagModel;
import com.better.xing.mongo.repository.TagRepository;
import com.better.xing.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/19 11:22
 */
@Service
public class TagServiceImpl implements ITagService {
    @Autowired
    private TagRepository tagRepository;
    @Override
    public String getTagId(String tagName) {
        TagModel tagModel = tagRepository.findTagModelByTagName(tagName);
        if(tagModel == null){
            tagModel = new TagModel();
            tagModel.setTagName(tagName);
            TagModel save = tagRepository.save(tagModel);
            return save.getId();
        }else{
            return tagModel.getId();
        }
    }
}
