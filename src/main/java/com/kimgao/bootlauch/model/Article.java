package com.kimgao.bootlauch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Article {
    private Long id;
    private String name;
    private String title;
    private String content;
    private Date createTime;
}
