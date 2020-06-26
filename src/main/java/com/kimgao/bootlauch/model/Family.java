package com.kimgao.bootlauch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
//当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），我们就可以使用@Component来标注这个类
@ConfigurationProperties(prefix = "family")
@Validated
public class Family {
    //@Value("${family.family-name}")
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
