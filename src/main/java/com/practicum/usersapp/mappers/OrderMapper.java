package com.practicum.usersapp.mappers;

import com.practicum.usersapp.dto.OrderDto;
import com.practicum.usersapp.model.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  OrderDto toDto(OrderEntity orderEntity);

  OrderEntity toModel(OrderDto orderDto);
}
