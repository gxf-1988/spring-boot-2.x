package com.kimgao.bootlauch.model;

import lombok.Data;

@Data
public class Child {
    private String name;
    private Integer age;
    private Friend[] friends;
}
