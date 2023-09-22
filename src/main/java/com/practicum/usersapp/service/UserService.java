package com.practicum.usersapp.service;

import com.practicum.usersapp.dao.UserDao;
import com.practicum.usersapp.model.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserDao userDao;

  public User createUser(@RequestBody User user) {
    return userDao.createUser(user);
  }

  public User findUserById(@PathVariable Integer id) {
    return userDao.findUserById(id);
  }

  public List<User> findAllUsers() {
    throw new RuntimeException("Not Implemented");
  }
}
