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
@Document(collection = "type")
public class TypeModel {
    @Id
    private String id;//主键
    private String name;//名称
    private Integer order;
}
