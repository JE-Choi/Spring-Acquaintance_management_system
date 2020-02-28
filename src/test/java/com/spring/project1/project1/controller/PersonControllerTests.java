package com.spring.project1.project1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PersonControllerTests {
    @Autowired
    private PersonController personController;

    private MockMvc mockMvc;

    @Test
    void getPerson() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/person/1"))
        .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void postPerson() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        mockMvc.perform(
          MockMvcRequestBuilders.post("/api/person")
                  .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{\n" +
                "    \"name\": \"martin2\", \n" +
                "    \"age\": 20, \n" +
                "    \"bloodType\" : \"A\"\n" +
                "}")
        )
        .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void modifyPerson() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/person/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "    \"name\": \"martin\", \n" +
                        "    \"age\": 20, \n" +
                        "    \"bloodType\" : \"A\"\n" +
                        "}")
        ).andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    void modifyName() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
        mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/person/1")
                .param("name","martin22")) // 여러 값이 아니니까 param으로 데이터 보냄.
        .andDo(print())
        .andExpect(status().isOk());
    }
}