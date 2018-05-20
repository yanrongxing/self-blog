package com.better.xing.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yanrx20795@hundsun.com
 * @date 2018/5/18 17:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tag")
public class TagModel {
    @Id
    private String id;//主键
    private String tagName;//标签名
}
