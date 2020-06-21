package com.kimgao.bootlauch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Article {
    private Long id;
    private String name;
    private String title;
    private String content;
    private Date createTime;

    private List<Reader> reader;
}
