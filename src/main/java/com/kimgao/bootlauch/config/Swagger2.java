package com.kimgao.bootlauch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档") //设置文档的标题
                .description("KimGao的API") //设置文档的描述->1.Overview
                .termsOfServiceUrl("http://www.kimgao.com") //设置文档的License信息->1.3 License information
                .version("1.0") //设置文档的版本信息-> 1.1 Version information
                .build();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描basePackage包下面的“/rest/”路径下的内容作为接口文档构建的目标
                .apis(RequestHandlerSelectors.basePackage("com.kimgao.bootlauch"))
                //.paths(PathSelectors.regex("/rest/.*"))
                //包下全部API用any
                .paths(PathSelectors.any())
                .build();
    }


}
