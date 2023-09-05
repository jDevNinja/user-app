package com.practicum.usersapp.controller;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = DEFINED_PORT)
class ControllerFullTest {

  @Autowired private TestRestTemplate testRestTemplate;

  @Test
  void findUserById_shouldReturnUser() {}
}
