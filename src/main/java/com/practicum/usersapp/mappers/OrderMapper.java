package com.practicum.usersapp.mappers;

import com.practicum.usersapp.dto.OrderDto;
import com.practicum.usersapp.model.OrderEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  OrderDto toDto(OrderEntity orderEntity);

  List<OrderDto> toDto(List<OrderEntity> orderEntity);

  OrderEntity toEntity(OrderDto orderDto);

  List<OrderEntity> toEntity(List<OrderDto> orderDto);
}
