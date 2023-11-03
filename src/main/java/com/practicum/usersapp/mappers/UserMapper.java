package com.practicum.usersapp.mappers;

import com.practicum.usersapp.dto.UserDto;
import com.practicum.usersapp.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(source = "id", target = "uuid")
  @Mapping(source = "age", target = "vozrast")
  @Mapping(source = "name", target = "firstName")
  UserDto toDto(UserEntity userEntity);

  @Mapping(source = "uuid", target = "id")
  @Mapping(source = "vozrast", target = "age")
  @Mapping(source = "firstName", target = "name")
  UserEntity toEntity(UserDto userDto);

  @Named("celsiusToFahrenteit")
  default double convertTemperature(Double celsius) {
    return celsius * 1.5;
  }
}
