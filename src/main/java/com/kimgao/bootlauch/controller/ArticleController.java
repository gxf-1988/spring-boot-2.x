package com.kimgao.bootlauch.controller;

import com.kimgao.bootlauch.AjaxResponse;
import com.kimgao.bootlauch.model.Article;
import com.kimgao.bootlauch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    ArticleService articleService;

    //根据ID查询一篇文章
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    //mapping 可以用下面的写法简写，省去RequestMethod
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        Article article =articleService.getArticle(id);
        return AjaxResponse.success(article);
    }

    //增加一篇Article ，使用POST方法(RequestBody方式接收参数)
    //@RequestMapping(value = "/articles",method = RequestMethod.POST)
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article){
        articleService.saveArticle(article);
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle:" + article);
        return AjaxResponse.success();
    }



    //更新一篇Article，使用PUT方法，以id为主键进行更新
    //@RequestMapping(value = "/articles",method = RequestMethod.PUT)
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    //删除一篇Article，使用DELETE方法，参数是id
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }

    @GetMapping("/articles")
    public AjaxResponse getArticle() {
        List<Article> articles =articleService.getAll();
        log.info("getall"+articles);
        return AjaxResponse.success(articles);
    }
}
