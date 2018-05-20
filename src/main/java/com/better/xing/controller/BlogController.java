package com.better.xing.controller;

import com.better.xing.common.util.ResponseUtil;
import com.better.xing.controller.base.RestBaseResp;
import com.better.xing.controller.request.BlogReq;
import com.better.xing.controller.response.AllBlogRep;
import com.better.xing.mongo.entity.BlogModel;
import com.better.xing.mongo.entity.TypeModel;
import com.better.xing.mongo.repository.TypeRepository;
import com.better.xing.service.IBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 21:28
 */
@Api(value = "博客接口",tags = {"博客操作接口"},description = "博客操作所以接口")
@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private TypeRepository typeRepository;
    @ApiOperation(value = "获取博客列表", notes = "获取所以博客列表", tags = "博客操作接口")
    @GetMapping("/")
    public String blogs(ModelMap modelMap){
        List<AllBlogRep> allBlog = blogService.findAllBlog();
        modelMap.put("blogs",allBlog);
        return "index";
    }
    @ApiOperation(value = "获取博客列表", notes = "获取所以博客列表", tags = "博客操作接口")
    @GetMapping("/manager")
    public String manager(@RequestParam("key") String key,ModelMap modelMap){
        if(StringUtils.isEmpty(key) || !"19960226".equals(key)){
            return "error";
        }
        List<AllBlogRep> allBlog = blogService.findAllBlog();
        modelMap.put("blogs",allBlog);
        return "manager";
    }
    @GetMapping("/blog")
    public String blog(@RequestParam String id,ModelMap modelMap){
        //获取博客详情
        BlogModel byId = blogService.findById(id);
        //获取类型名字
        String type = byId.getType();
        Optional<TypeModel> byId1 = typeRepository.findById(type);
        modelMap.put("type",byId1.get());
        modelMap.put("blogs",blogService.findBlogModelsByType(type));
        modelMap.put("blog",byId);
        return "info";
    }
    @ApiOperation(value = "创建博客", notes = "创建博客", tags = "博客操作接口")
    @GetMapping("/report")
    public String report(@RequestParam("key") String key,ModelMap modelMap){
        if(StringUtils.isEmpty(key) || !"19960226".equals(key)){
            return "error";
        }
        //获取分类
        modelMap.put("types",blogService.findAllType());
        return "report";
    }
    @ApiOperation(value = "创建博客", notes = "创建博客", tags = "博客操作接口")
    @GetMapping("/alter/{id}")
    public String alter(@RequestParam("key") String key,@PathVariable String id,ModelMap modelMap){
        if(StringUtils.isEmpty(key) || !"19960226".equals(key)){
            return "error";
        }
        modelMap.put("blog",blogService.findById(id));
        //获取分类
        modelMap.put("types",blogService.findAllType());
        return "alter";
    }
    @ApiOperation(value = "创建博客", notes = "创建博客", tags = "博客操作接口")
    @PutMapping("/blog")
    @ResponseBody
    public RestBaseResp putBlog(@ApiParam(name = "BlogReq",value = "创建博客参数")@RequestBody BlogModel req){
        blogService.insertBlog(req);
        return ResponseUtil.genSuccess();
    }

    @ApiOperation(value = "修改博客", notes = "修改博客", tags = "博客操作接口")
    @PostMapping("/blog")
    @ResponseBody
    public RestBaseResp postBlog(@ApiParam(name = "BlogReq",value = "更新博客参数")@RequestBody BlogModel req){
        blogService.updateBlog(req);
        return ResponseUtil.genSuccess();

    }
    @ApiOperation(value = "修改博客", notes = "修改博客", tags = "博客操作接口")
    @DeleteMapping("/blog/{id}")
    @ResponseBody
    public RestBaseResp deleteBlog(@PathVariable String id){
        blogService.deleteBlog(id);
        return ResponseUtil.genSuccess();
    }
}
