package com.better.xing.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 21:55
 */
@ApiModel(value = "博客参数",description = "博客参数")
@Data
public class BlogReq {
    @ApiModelProperty(value = "主键",notes = "主键",dataType = "Long")
    private Long id;//主键
    @ApiModelProperty(value = "标题",notes = "标题",dataType = "String")
    private String title;//标题
    @ApiModelProperty(value = "简介",notes = "简介",dataType = "String")
    private String description;//简介
    @ApiModelProperty(value = "作者",notes = "作者",dataType = "String")
    private String autor;//作者
    @ApiModelProperty(value = "分类",notes = "分类",dataType = "String")
    private String type;//分类
    @ApiModelProperty(value = "标签",notes = "标签",dataType = "Long []")
    private String [] tags;//标签
    @ApiModelProperty(value = "文章路径",notes = "文章路径",dataType = "String")
    private String detailMd;//详细文章markdown
}
