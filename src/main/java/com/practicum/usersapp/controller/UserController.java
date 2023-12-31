package com.practicum.usersapp.controller;

import com.practicum.usersapp.dto.UserDto;
import com.practicum.usersapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

  private final UserService userService;

  @GetMapping("/{id}")
  @ApiOperation("Получение пользователя по ID")
  public UserDto findUserById(@PathVariable Integer id) {
    return userService.findById(id);
  }

  @PostMapping
  @ApiOperation("Создание пользователя")
  public UserDto createUser(@RequestBody UserDto user) {
    return userService.save(user);
  }
}
