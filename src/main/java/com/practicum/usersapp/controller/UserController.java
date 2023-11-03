package com.practicum.usersapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.practicum.usersapp.dto.UserDto;
import com.practicum.usersapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    return userService.findUserById(id);
  }

  @PostMapping
  @ApiOperation("Создание пользователя")
  public UserDto createUser(@RequestBody UserDto user) {
    return userService.createUser(user);
  }

  @GetMapping("/list")
  @ApiOperation("Получение всех пользователей")
  public List<UserDto> findAllUsers() {
    throw new RuntimeException("Not Implemented");
  }

  @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
  public ResponseEntity<UserDto> updateUser(
      @PathVariable Integer id, @RequestBody JsonPatch patch) {
    try {
      UserDto updatedUser = userService.updateUser(id, patch);
      return ResponseEntity.ok(updatedUser);
    } catch (JsonPatchException | JsonProcessingException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
