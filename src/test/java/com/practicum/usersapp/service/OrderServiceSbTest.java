package com.practicum.usersapp.service;

import com.practicum.usersapp.dao.OrderRepository;
import com.practicum.usersapp.dto.OrderDto;
import com.practicum.usersapp.mappers.OrderMapper;
import com.practicum.usersapp.mappers.OrderMapperImpl;
import com.practicum.usersapp.model.OrderEntity;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = {OrderService.class, OrderMapperImpl.class})
@ContextConfiguration(classes = {OrderService.class, OrderMapperImpl.class})
class OrderServiceSbTest {

  @MockBean private OrderRepository orderRepository;
  @Autowired private OrderService orderService;
  @SpyBean private OrderMapper orderMapper;

  @Test
  void findById_returnsOrderDtoWhenFound() {
    int orderId = 1;

    OrderEntity existingOrder =
        OrderEntity.builder().id(orderId).description("Утюг").status("NEW").build();
    Mockito.when(orderRepository.findById(orderId)).thenReturn(Optional.of(existingOrder));

    OrderDto expectedOrderDto =
        OrderDto.builder().id(orderId).description("Утюг").status("NEW").build();

    OrderDto actualOrderDto = orderService.findById(orderId);

    Assertions.assertEquals(expectedOrderDto, actualOrderDto);
    Mockito.verify(orderRepository, Mockito.times(1)).findById(orderId);
    Mockito.verifyNoMoreInteractions(orderRepository);

    Mockito.verify(orderMapper, Mockito.times(1)).toDto(existingOrder);
  }
}
