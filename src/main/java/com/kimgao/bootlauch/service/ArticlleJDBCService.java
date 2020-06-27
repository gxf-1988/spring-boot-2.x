package com.kimgao.bootlauch.service;

import com.kimgao.bootlauch.dao.ArticleJDBCDAO;
import com.kimgao.bootlauch.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticlleJDBCService implements ArticleService{

    @Resource
    private
    ArticleJDBCDAO articleJDBCDAO;

    @Transactional
    public void saveArticle( Article article) {
        articleJDBCDAO.save(article);
    }

    @Override
    public void deleteArticle(Long id){
        articleJDBCDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateArticle(Article article){
        if(article.getId() == null){
            //抛出异常，以后写
        }
        //删除后新增
        articleJDBCDAO.deleteById(article.getId());
        articleJDBCDAO.save(article);
        //articleJDBCDAO.updateById(article);
        //制作一个异常
        int a = 10/0;
    }

    @Override
    public Article getArticle(Long id){
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll(){
        return articleJDBCDAO.findAll();
    }
}
