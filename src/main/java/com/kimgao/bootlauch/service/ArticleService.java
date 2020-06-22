package com.kimgao.bootlauch.service;

import com.kimgao.bootlauch.model.Article;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArticleService {
    public String saveArticle(Article article) {
        log.info("执行到service层"+article);
        return "测试";
    }
}
