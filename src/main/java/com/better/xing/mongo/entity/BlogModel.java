package com.better.xing.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/16 21:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "blog")
public class BlogModel {
    @Id
    private String id;//主键
    private String title;//标题
    private String description;//简介
    private String autor;//作者
    private String type;//分类
    private String [] tags;//标签
    private String detailMd;//详细文章markdown
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}
