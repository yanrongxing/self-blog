package com.better.xing.controller;

import com.better.xing.mongo.entity.TypeModel;
import com.better.xing.mongo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/19 18:07
 */
@Controller
public class TypeController {
    @Autowired
    private TypeRepository typeRepository;
    @GetMapping("/type")
    @ResponseBody
    public String addType(TypeModel type){
        typeRepository.save(type);
        return "success";
    }
}
