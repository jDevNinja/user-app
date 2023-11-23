package com.practicum.usersapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practicum.usersapp.dto.UserDto;
import com.practicum.usersapp.service.UserService;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @MockBean private UserService userService;

  @Test
  void createUser() throws Exception {
    UserDto userDto = UserDto.builder().name("Alice").age(20).build();
    UserDto savedUserDto = UserDto.builder().id(1).name("Alice").age(20).build();

    Mockito.when(userService.save(userDto)).thenReturn(savedUserDto);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/v1/users")
                .content(objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(savedUserDto)));

    Mockito.verify(userService, Mockito.times(1)).save(userDto);
    Mockito.verifyNoMoreInteractions(userService);
  }
}
