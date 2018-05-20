package com.better.xing.controller;

import com.better.xing.common.util.ResponseUtil;
import com.better.xing.controller.base.RestBaseResp;
import com.better.xing.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/18 16:30
 */
@Controller
public class TagController {
    @Autowired
    private ITagService iTagService;
    @ResponseBody
    @GetMapping("/tagid/{tagName}")
    public RestBaseResp<Long> getTagId(@PathVariable("tagName") String tagName){
        String tagId = iTagService.getTagId(tagName);
        return ResponseUtil.genSuccessAndRespBody(tagId);
    }
}
