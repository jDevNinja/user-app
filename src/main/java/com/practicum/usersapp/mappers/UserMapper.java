package com.practicum.usersapp.mappers;

import com.practicum.usersapp.dto.UserDto;
import com.practicum.usersapp.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto toDto(UserModel userModel);

  UserModel toModel(UserDto userDto);
}
