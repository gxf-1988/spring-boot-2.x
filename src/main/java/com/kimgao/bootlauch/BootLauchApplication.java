package com.kimgao.bootlauch;

import com.kimgao.bootlauch.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootLauchApplication {

    public static void main(String[] args) {

        LombokPOJO lombokPOJO = LombokPOJO.builder()
                .name("kimgao")
                .age(32)
                .build();

        SpringApplication.run(BootLauchApplication.class, args);
    }

}
