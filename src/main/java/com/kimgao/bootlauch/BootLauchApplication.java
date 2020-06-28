package com.kimgao.bootlauch;

import com.kimgao.bootlauch.model.LombokPOJO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.kimgao.bootlauch.generator"})
public class BootLauchApplication {

    public static void main(String[] args) {

        LombokPOJO lombokPOJO = LombokPOJO.builder()
                .name("kimgao")
                .age(32)
                .build();

        SpringApplication.run(BootLauchApplication.class, args);
    }

}
