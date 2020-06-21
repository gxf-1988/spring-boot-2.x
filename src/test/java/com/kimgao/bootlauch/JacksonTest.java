package com.kimgao.bootlauch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kimgao.bootlauch.model.Article;
import com.kimgao.bootlauch.model.Reader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {

    @Test
    void testJacson() throws JsonProcessingException {
        //jackson 的 ObjectMapper 转换对象
        ObjectMapper mapper = new ObjectMapper();

        List<Reader> readers = new ArrayList<Reader>(){{
            add(new Reader("kobe",21));
            add(new Reader("kimgao",32));

        }};

        Article article = Article.builder()
                .id(1L)
                .author("kimgao")
                .content("青铜")
                .createTime(new Date())
                .reader(readers)
                .title("T1")
                .build();
        //序列化与反序列化
        //将java多项转换为JSON字符串
        String jsonStr = mapper.writeValueAsString(article);
        System.out.println(jsonStr);
        //将JSON字符串转换为Java对象
        Article article1 = mapper.readValue("{\"content\":\"青铜\",\"title\":\"T1\",\"createTime\":\"2020/06/21 23:31:57\",\"reader\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"kimgao\",\"age\":32}],\"auther\":\"kimgao\"}"
        ,Article.class);
        System.out.println(article1);
    }

}
