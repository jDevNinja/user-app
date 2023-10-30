package com.practicum.usersapp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  @ApiModelProperty(value = "Идентификатор", example = "1")
  private Integer uuid;

  @ApiModelProperty(value = "Имя", example = "Иван")
  private String firstName;

  @ApiModelProperty(value = "Фамилия", example = "Петров")
  private String lastName;

  @ApiModelProperty(value = "Возраст", example = "25")
  private Integer vozrast;

  @ApiModelProperty(value = "Температура", example = "25")
  private Double temperatureFahrenteit;
}
