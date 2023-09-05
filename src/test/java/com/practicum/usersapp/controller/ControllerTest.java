package com.practicum.usersapp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

  @Autowired MockMvc mockMvc;

  @Test
  void findUserById_shouldReturnUser() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/users/1"))
        .andExpect(status().isOk())
        .andExpect(content().string("{\"id\":\"1\",\"name\":\"Alice\"}"));
  }
}
