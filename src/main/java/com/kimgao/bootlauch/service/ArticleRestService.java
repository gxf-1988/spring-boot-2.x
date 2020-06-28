package com.kimgao.bootlauch.service;

import com.kimgao.bootlauch.model.ArticleVO;

import java.util.List;

public interface ArticleRestService {
    ArticleVO saveArticle(ArticleVO article);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}
