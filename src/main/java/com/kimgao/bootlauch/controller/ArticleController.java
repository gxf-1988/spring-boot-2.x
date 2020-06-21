package com.kimgao.bootlauch.controller;

import com.kimgao.bootlauch.AjaxResponse;
import com.kimgao.bootlauch.model.Article;
import com.kimgao.bootlauch.model.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {

    //根据ID查询一篇文章
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    //mapping 可以用下面的写法简写，省去RequestMethod
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {

        List<Reader> readers = new ArrayList<Reader>(){{
            add(new Reader("kobe",21));
            add(new Reader("kimgao",32));

        }};

        Article article = Article.builder()
                .id(1L)
                .author("kimgao")
                .content("青铜")
                .createTime(new Date())
                .reader(readers)
                .title("T1")
                .build();
        log.info("articel:"+article);
        return AjaxResponse.success(article);
    }

    //增加一篇Article ，使用POST方法(RequestBody方式接收参数)
    //@RequestMapping(value = "/articles",method = RequestMethod.POST)
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article){

        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle:" + article);
        return AjaxResponse.success();
    }

    //增加一篇Article ，使用POST方法(RequestParam方式接收参数)
  /*@PostMapping("/articles")
  public AjaxResponse saveArticle(@RequestParam  String author,
                                  @RequestParam  String title,
                                  @RequestParam  String content,
                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                  @RequestParam  Date createTime){

    log.info("saveArticle:" + createTime);
    return AjaxResponse.success();
  }*/


    //更新一篇Article，使用PUT方法，以id为主键进行更新
    //@RequestMapping(value = "/articles",method = RequestMethod.PUT)
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article){
        if(article.getId() == null){
            //article.id是必传参数，因为通常根据id去修改数据
            //TODO 抛出一个自定义的异常
        }

        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    //删除一篇Article，使用DELETE方法，参数是id
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){

        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }
}
