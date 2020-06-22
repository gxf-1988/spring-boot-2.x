package com.kimgao.bootlauch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kimgao.bootlauch.model.Article;
import com.kimgao.bootlauch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleRestControllerTest2 {

    //mock对象
    @Resource
    private  MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    //在所有测试方法执行之前进行mock对象初始化

    //测试方法
    @Test
    public void saveArticle() throws Exception {

        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017/07/16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article articleObj = objectMapper.readValue(article,Article.class);

        log.info("articleObj:"+articleObj);

        //打桩
        when(articleService.saveArticle(articleObj)).thenReturn("ok");

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/articles")
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(article))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok"))
                .andDo(print())
                .andReturn();

        //result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());

    }
}