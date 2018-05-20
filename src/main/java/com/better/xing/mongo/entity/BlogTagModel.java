package com.better.xing.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/18 17:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "blog_tag")
public class BlogTagModel {
    @Id
    private String id;
    private String blogId;
    private String tagId;
}
