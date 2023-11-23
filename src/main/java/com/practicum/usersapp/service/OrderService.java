package com.practicum.usersapp.service;

import com.practicum.usersapp.dao.OrderRepository;
import com.practicum.usersapp.dto.OrderDto;
import com.practicum.usersapp.mappers.OrderMapper;
import com.practicum.usersapp.model.OrderEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;

  public OrderDto findById(Integer id) {
    OrderEntity order =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Заказ не найден"));
    return orderMapper.toDto(order);
  }

  public OrderDto save(OrderDto newOrder) {
    OrderEntity order = orderMapper.toEntity(newOrder);
    order = orderRepository.save(order);
    return orderMapper.toDto(order);
  }

  public List<OrderDto> findAll() {
    List<OrderEntity> all = orderRepository.findAllByOrderByDescriptionAsc();
    return orderMapper.toDto(all);
  }
}
