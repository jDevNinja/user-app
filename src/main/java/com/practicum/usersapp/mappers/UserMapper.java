package com.practicum.usersapp.mappers;

import com.practicum.usersapp.dto.UserDto;
import com.practicum.usersapp.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto toDto(UserEntity userEntity);

  UserEntity toEntity(UserDto userDto);
}
