package com.memory.memoryshop.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Post 요청시 Hello World를 출력한다.")
    void test() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/posts"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Hello World!"))
//                .andDo(print());

        mockMvc.perform(post("/posts")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//                .param("title", "타이틀입니다")
//                .param("content", "content입니다"))
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                                "\"title\" : \"title입니다\", " +
                                "\"content\" : \"content입니다.\" " +
                        "}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"))
                .andDo(print());

    }

}
