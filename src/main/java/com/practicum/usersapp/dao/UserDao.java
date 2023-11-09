package com.practicum.usersapp.dao;

import com.practicum.usersapp.model.UserModel;
import java.sql.PreparedStatement;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@RequiredArgsConstructor
public class UserDao {

  private final JdbcTemplate jdbcTemplate;

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  private final RowMapper<UserModel> userMapper =
      (rs, rowNum) ->
          UserModel.builder()
              .id(rs.getInt("id"))
              .name(rs.getString("name"))
              .lastName(rs.getString("lastName"))
              .age(rs.getInt("age"))
              .build();

  public UserModel createUser(@RequestBody UserModel user) {
    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(
        connection -> {
          PreparedStatement preparedStatement =
              connection.prepareStatement(
                  "INSERT INTO users (name, lastName, age) values (?, ?, ?)", new String[] {"id"});
          preparedStatement.setString(1, user.getName());
          preparedStatement.setString(2, user.getLastName());
          preparedStatement.setInt(3, user.getAge());
          return preparedStatement;
        },
        keyHolder);

    user.setId(keyHolder.getKey().intValue());

    return user;
  }

  public UserModel findUserById(@PathVariable Integer id) {
    MapSqlParameterSource paramSource = new MapSqlParameterSource();
    paramSource.addValue("id", id);
    return namedParameterJdbcTemplate.queryForObject(
        "SELECT * FROM users WHERE id = :id", paramSource, userMapper);
  }

  public List<UserModel> findAllUsers() {
    throw new RuntimeException("Not Implemented");
  }
}
