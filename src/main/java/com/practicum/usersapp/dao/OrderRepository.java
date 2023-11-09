package com.practicum.usersapp.dao;

import com.practicum.usersapp.model.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {}
