package com.practicum.usersapp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "Пользователь")
public class User {

  @ApiModelProperty(value = "Идентификатор", example = "eb79a730-dc38-4387-a931-af68fc25f236")
  private String id;

  @ApiModelProperty(value = "Имя", example = "Bob")
  private String name;
}
