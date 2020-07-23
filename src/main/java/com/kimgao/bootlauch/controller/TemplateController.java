package com.kimgao.bootlauch.controller;

import com.kimgao.bootlauch.model.ArticleVO;
import com.kimgao.bootlauch.service.ArticleRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource(name="articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;

    @GetMapping("/thymeleaf")
    public String index(Model model, HttpSession session) {

        List<ArticleVO> articles = articleRestService.getAll();

        model.addAttribute("articles", articles);

        Map<String,String> user = new HashMap<>();
        user.put("id","1");
        user.put("username","kim");
        user.put("password","123456");

        model.addAttribute("user",user);

        session.setAttribute("foo","asdasd");

        //模版名称，实际的目录为：resources/templates/thymeleaftemp.html
        return "thymeleaftemp";
    }
}