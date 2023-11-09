package com.practicum.usersapp.service;

import com.practicum.usersapp.dao.OrderRepository;
import com.practicum.usersapp.dto.OrderDto;
import com.practicum.usersapp.mappers.OrderMapper;
import com.practicum.usersapp.model.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;

  public OrderDto findById(Integer id) {
    OrderEntity order = orderRepository.findById(id).get();
    return orderMapper.toDto(order);
  }
  
}
