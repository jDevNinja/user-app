package com.practicum.usersapp.controller;

import com.practicum.usersapp.dto.OrderDto;
import com.practicum.usersapp.service.OrderService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/{id}")
  @ApiOperation("Получение пользователя по ID")
  public OrderDto findOrderById(@PathVariable Integer id) {
    return orderService.findById(id);
  }

  @PostMapping
  @ApiOperation("Создание пользователя")
  public OrderDto saveOrder(@RequestBody OrderDto user) {
    return orderService.save(user);
  }

  @GetMapping("/list")
  @ApiOperation("Получение всех пользователей")
  public List<OrderDto> findAllOrders() {
    return orderService.findAll();
  }
}
