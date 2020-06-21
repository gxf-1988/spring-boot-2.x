package com.kimgao.bootlauch.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Slf4j
@Builder
@AllArgsConstructor
public class LombokPOJO {

    //private static final Logger log = LoggerFactory.getLogger(LombokPOJO.class);

    private String name;

    private  Integer age;
}
