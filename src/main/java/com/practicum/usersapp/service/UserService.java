package com.practicum.usersapp.service;

import com.practicum.usersapp.dao.UserDao;
import com.practicum.usersapp.dto.UserDto;
import com.practicum.usersapp.mappers.UserMapper;
import com.practicum.usersapp.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserDao userDao;
  private final UserMapper userMapper;

  public UserDto save(@RequestBody UserDto user) {
    UserModel userModel = userMapper.toModel(user);
    userModel = userDao.createUser(userModel);
    return userMapper.toDto(userModel);
  }

  public UserDto findById(Integer id) {
    return userMapper.toDto(userDao.findUserById(id));
  }
}
