package com.practicum.usersapp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "Пользователь")
@Builder
public class User {

  @ApiModelProperty(value = "Идентификатор", example = "1")
  private Integer id;

  @ApiModelProperty(value = "Имя", example = "Bob")
  @NotNull
  private String name;

  @ApiModelProperty(value = "Фамилия", example = "Smith")
  private String lastName;

  @ApiModelProperty(value = "Возраст", example = "27")
  private Integer age;
}
