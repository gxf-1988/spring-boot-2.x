package com.kimgao.bootlauch.controller;


import com.kimgao.bootlauch.customlistener.MyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ListenerController {

    @Resource
    ConfigurableApplicationContext applicationContext;

    @RequestMapping("/publish")
    public String hello() {
        applicationContext.publishEvent(new MyEvent("邮件内容"));
        return "OK";
    }

}
