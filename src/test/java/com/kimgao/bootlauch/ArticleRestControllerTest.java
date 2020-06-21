package com.kimgao.bootlauch;

import com.kimgao.bootlauch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
class ArticleRestControllerTest {

    //mock对象
    private static MockMvc mockMvc;

    //在所有测试方法执行之前进行mock对象初始化
    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    //测试方法
    @Test
    public void saveArticle() throws Exception {

        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles")
                        .contentType("application/json")
                        .content(article)
        )
                .andDo(print())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());

    }
}