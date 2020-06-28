package com.kimgao.bootlauch.controller;

import com.kimgao.bootlauch.AjaxResponse;
import com.kimgao.bootlauch.model.ArticleVO;
import com.kimgao.bootlauch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {


    @Resource(name = "articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;

    //增加一篇Article ，使用POST方法
    //PostMapping 等于 RequestMapping 里的POST其他方法同理
    //@RequestMapping(value = "/article", method = POST, produces = "application/json")
    @PostMapping("/articles")
    public @ResponseBody  AjaxResponse saveArticle(@RequestBody ArticleVO article) {

        articleRestService.saveArticle(article);
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}",article);

        return  AjaxResponse.success(article);
    }


    //删除一篇Article，使用DELETE方法，参数是id
    //@PathVariable 是对url定位路径的，用于操作id对应数据
    //@RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/articles/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable Long id) {

        articleRestService.deleteArticle(id);

        return AjaxResponse.success(id);

    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    //@RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    @PutMapping("/articles/{id}")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO article) {
        article.setId(id);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    //@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping("/articles/{id}")
    public @ResponseBody AjaxResponse getArticle(@PathVariable Long id) {

        //使用lombok提供的builder构建对象
        log.info("get info by id controller"+id);
        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    @GetMapping("/articles")
    public @ResponseBody  AjaxResponse getAll() {

        //使用lombok提供的builder构建对象
        log.error("Get all info controller");
        return AjaxResponse.success(articleRestService.getAll());
    }
}
