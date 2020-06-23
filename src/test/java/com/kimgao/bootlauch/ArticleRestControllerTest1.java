package com.kimgao.bootlauch;

import com.kimgao.bootlauch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleRestControllerTest1 {

    //mock对象
    @Resource
    private  MockMvc mockMvc;


    //在所有测试方法执行之前进行mock对象初始化
    /*@BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }
*/
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
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles")
                        .contentType("application/json")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .content(article)
        )
                .andDo(print())
                .andReturn();
        
        //result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());

    }
}