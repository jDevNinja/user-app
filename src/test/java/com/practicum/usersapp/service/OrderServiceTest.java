package com.practicum.usersapp.service;

import com.practicum.usersapp.dao.OrderRepository;
import com.practicum.usersapp.dto.OrderDto;
import com.practicum.usersapp.mappers.OrderMapper;
import com.practicum.usersapp.model.OrderEntity;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

  @Mock private OrderMapper userMapper;
  @Mock private OrderRepository orderRepository;

  private @InjectMocks OrderService orderService;

  @Test
  void findById_returnsOrderDtoWhenFound() {
    int orderId = 1;

    OrderEntity existingOrder =
        OrderEntity.builder().id(orderId).description("Утюг").status("NEW").build();
    Mockito.when(orderRepository.findById(orderId)).thenReturn(Optional.of(existingOrder));

    OrderDto expectedOrderDto =
        OrderDto.builder().id(orderId).description("Утюг").status("NEW").build();

    Mockito.when(userMapper.toDto(existingOrder)).thenReturn(expectedOrderDto);

    OrderDto actualOrderDto = orderService.findById(orderId);

    Assertions.assertEquals(expectedOrderDto, actualOrderDto);
  }
}
