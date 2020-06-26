package com.kimgao.bootlauch.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Father {
    private String name;
    @Min(21)
    private Integer age;
}
