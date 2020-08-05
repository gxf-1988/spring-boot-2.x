package com.kimgao.bootlauch;

import com.kimgao.bootlauch.customlistener.MyListener1;
import com.kimgao.bootlauch.model.LombokPOJO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan(basePackages = {"com.kimgao.bootlauch.generator"})
@ServletComponentScan
@EnableAsync
public class BootLauchApplication {

    public static void main(String[] args) {

        LombokPOJO lombokPOJO = LombokPOJO.builder()
                .name("kimgao")
                .age(32)
                .build();

        ConfigurableApplicationContext context = SpringApplication.run(BootLauchApplication.class, args);
        //装载监听
        context.addApplicationListener(new MyListener1());
    }

}
