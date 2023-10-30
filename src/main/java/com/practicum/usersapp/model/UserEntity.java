package com.practicum.usersapp.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "Пользователь")
@Builder
public class UserEntity {

  private Integer id;

  private String name;

  private String lastName;

  private Integer age;

  private Double temperatureCelsius;
}
