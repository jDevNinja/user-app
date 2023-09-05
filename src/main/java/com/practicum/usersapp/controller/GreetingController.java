package com.practicum.usersapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  @Value("${com.practicum.user-app.message}")
  private String message;

  @GetMapping
  public String greet() {
    return message;
  }
}
