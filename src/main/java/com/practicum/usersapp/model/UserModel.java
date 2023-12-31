package com.practicum.usersapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

  private Integer id;

  private String name;

  private String lastName;

  private Integer age;
}
