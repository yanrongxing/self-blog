package com.better.xing.controller.response;

import com.better.xing.mongo.entity.TypeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/19 21:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllBlogRep {
    private String id;//主键
    private String title;//标题
    private String description;//简介
    private String autor;//作者
    private TypeModel typeModel;//类型
    private String [] tags;//标签
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}
