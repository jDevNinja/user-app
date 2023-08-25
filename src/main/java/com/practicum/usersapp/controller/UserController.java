package com.practicum.usersapp.controller;

import com.practicum.usersapp.configuration.UuidGenerator;
import com.practicum.usersapp.dto.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Api(tags = "UserController", description = "Операции с пользователями")
public class UserController {

  private final UuidGenerator uuidGenerator;

  private final Map<String, User> idToUser =
      new HashMap<>() {
        {
          put("1", new User("1", "Alice"));
          put("2", new User("2", "Alice"));
        }
      };

  @GetMapping("/list")
  public List<User> findAllUsers() {
    return new ArrayList<>(idToUser.values());
  }

  @GetMapping("/{id}")
  @ApiOperation("Получение пользователя по ID")
  public User findUserById(@PathVariable String id) {
    return idToUser.get(id);
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    if (idToUser.containsKey(user.getId())) {
      throw new RuntimeException("Пользователь с таким id уже есть.");
    }
    user.setId(uuidGenerator.nextUuid());
    idToUser.put(user.getId(), user);
    return user;
  }
}
