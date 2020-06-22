package com.kimgao.bootlauch;

import com.kimgao.bootlauch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public class ArticleRestControllerTest {
    //Mock对象
    private static MockMvc mockMvc;

    @BeforeAll
    static void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

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
        log.info(article);
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                    .request(HttpMethod.POST,"/rest/articles")
                    .contentType("application/json")
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(article)
        )
         .andExpect(MockMvcResultMatchers.status().isOk())  //HTTP:status 200
         .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
         .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
         .andDo(print())
         .andReturn();
        //mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }

}
