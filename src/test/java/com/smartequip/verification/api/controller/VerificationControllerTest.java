package com.smartequip.verification.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartequip.verification.api.service.dto.QuestionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VerificationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void serviceOne() throws Exception {

        mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void serviceTwo() throws Exception {
        QuestionDto q1 = getQuestion();
        mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(q1)))
                .andExpect(status().isBadRequest());
    }

    private QuestionDto getQuestion(){
        int num[] = {1,2,3};
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestion("");
        questionDto.setNumbers(num);
        return questionDto;
    }
}