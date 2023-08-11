package com.practicum.usersapp.controller;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import com.practicum.usersapp.dto.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = DEFINED_PORT)
class ControllerFullTest {

  @Autowired private TestRestTemplate testRestTemplate;

  @Test
  void findUserById_shouldReturnUser() {
    User expectedUser = new User(1, "Alice");

    User actualUser =
        testRestTemplate.getForObject("http://localhost:8080/api/v1/users?id=1", User.class);

    Assertions.assertNotNull(actualUser);
    Assertions.assertEquals(expectedUser, actualUser);
  }
}
