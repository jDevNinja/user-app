package com.practicum.usersapp.service;

import com.practicum.usersapp.dto.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public User getUserById(int id) {
    return new User(0, "Mary");
  }
}