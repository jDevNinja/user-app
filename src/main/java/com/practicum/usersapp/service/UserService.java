package com.practicum.usersapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.practicum.usersapp.dao.UserDao;
import com.practicum.usersapp.dto.UserDto;
import com.practicum.usersapp.mappers.UserMapper;
import com.practicum.usersapp.model.UserEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserDao userDao;
  private final UserMapper userMapper;
  private final ObjectMapper objectMapper;

  public UserDto createUser(@RequestBody UserDto user) {
    UserEntity userEntity = userMapper.toEntity(user);
    userEntity = userDao.createUser(userEntity);
    return userMapper.toDto(userEntity);
  }

  public UserDto updateUser(Integer id, JsonPatch patch)
      throws JsonPatchException, JsonProcessingException {
    UserEntity user = userDao.findUserById(id);
    log.info("До применения patch:\n{}", user);

    user = applyPatchToUser(patch, user);
    log.info("После применения patch:\n{}", user);
    // ..здесь нужно вызвать метод UserDao по сохранению
    // user = userDao.save(user);
    return userMapper.toDto(user);
  }

  public UserDto findUserById(Integer id) {
    return userMapper.toDto(userDao.findUserById(id));
  }

  public List<UserDto> findAllUsers() {
    throw new RuntimeException("Not Implemented");
  }

  private UserEntity applyPatchToUser(JsonPatch patch, UserEntity userDto)
      throws JsonPatchException, JsonProcessingException {
    JsonNode patched = patch.apply(objectMapper.convertValue(userDto, JsonNode.class));
    return objectMapper.treeToValue(patched, UserEntity.class);
  }
}
