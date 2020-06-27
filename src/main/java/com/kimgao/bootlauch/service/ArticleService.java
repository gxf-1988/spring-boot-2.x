package com.kimgao.bootlauch.service;

import com.kimgao.bootlauch.model.Article;

import java.util.List;

public interface ArticleService {
    void saveArticle(Article article) ;

    void deleteArticle(Long id);

    void updateArticle(Article article);

    Article getArticle(Long id);

    List<Article> getAll();
}
