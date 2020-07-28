package com.kimgao.bootlauch.service;

import com.kimgao.bootlauch.generator.Article;
import com.kimgao.bootlauch.generator.ArticleMapper;
import com.kimgao.bootlauch.model.ArticleVO;
import com.kimgao.bootlauch.uitls.DozerUtils;

import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService{

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    //新增
    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.insert(articlePO);
        return null;
    }

    //删除
    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id.intValue());
    }

    //更新
    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    //查询
    @Override
    public ArticleVO getArticle(Long id) {
        log.info("get id"+id);
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id.intValue()),ArticleVO.class);
    }
    //查询所有
    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);
    }
}
