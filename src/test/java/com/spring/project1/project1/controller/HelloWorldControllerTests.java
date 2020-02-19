package com.spring.project1.project1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
// 해당 파일이 springBootTest임을 명시
@SpringBootTest
class HelloWorldControllerTests {
    //Spring컨텍스트에서 Bean을 주입한다는 의미
    @Autowired
    private HelloWorldController helloWorldController;

    private MockMvc mockMvc;
    @Test
    void helloWorld() {
        // sout + enter하면 자동완성됨.
        System.out.println(helloWorldController.helloWorld());
        assertThat(helloWorldController.helloWorld()).isEqualTo("HelloWorld");
    }

    @Test
    void mockMvcTest() throws Exception {
        //mockMvc setting
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
        // 실제 동작하도록 요청(get)
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/helloWorld")
        ).andDo(MockMvcResultHandlers.print()) //Request와 Response에 관한 더 자세한 정보
        .andExpect(MockMvcResultMatchers.status().isOk())// HTTP statue가 ok인지 체크
        .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));// Response Body의 내용 체크
    }
}