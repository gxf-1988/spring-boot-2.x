package com.kimgao.bootlauch.controller;

import com.kimgao.bootlauch.config.exception.AjaxResponse;
import com.kimgao.bootlauch.service.ExceptionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    ExceptionService exceptionService;

    @RequestMapping("/hello")
    public String hello(String name){
        return "hello world1 -----------"+name;
    }


    @RequestMapping("/ex/service")
    public @ResponseBody AjaxResponse system(){
        exceptionService.systemBizError();
        return AjaxResponse.success();
    }

    @RequestMapping("/ex/user")
    public @ResponseBody AjaxResponse user(Integer input){
        //请求成功返回数据
        return AjaxResponse.success(exceptionService.userBizError(input));
    }
}
