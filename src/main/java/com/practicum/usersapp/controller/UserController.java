package com.practicum.usersapp.controller;

import com.practicum.usersapp.dto.User;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private Map<Integer, User> idToUser =
      new HashMap<>() {
        {
          put(1, new User(1, "Alice"));
          put(2, new User(2, "Alice"));
        }
      };

  @GetMapping("?list")
  public Map<Integer, User> findAllUsers() {
    return idToUser;
  }

  @GetMapping
  public User findUserById(int id) {
    return idToUser.get(id);
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    if (idToUser.containsKey(user.getId())) {
      throw new RuntimeException("Пользователь с таким id уже есть.");
    }
    idToUser.put(user.getId(), user);
    return user;
  }
}
