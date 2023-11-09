package com.practicum.usersapp.dao;

import com.practicum.usersapp.model.OrderEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
  List<OrderEntity> findAll();

  List<OrderEntity> findAllByOrderByDescriptionAsc();

  int countAllByStatusIn(List<String> statuses);
}
