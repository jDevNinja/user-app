package com.practicum.usersapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.practicum.usersapp.dao.OrderRepository;
import com.practicum.usersapp.model.OrderEntity;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class OrderRepositoryTest {
  @Autowired private OrderRepository orderRepository;

  @Test
  @Transactional
  void findById_shouldReturnOrder() {
    OrderEntity order = OrderEntity.builder().description("Телефон").status("DELIVERED").build();
    OrderEntity savedOrder = orderRepository.save(order);

    OrderEntity expectedEntity =
        OrderEntity.builder().id(1).description("Телефон").status("DELIVERED").build();

    Optional<OrderEntity> actualOrder = orderRepository.findById(savedOrder.getId());

    Assertions.assertTrue(actualOrder.isPresent());
    Assertions.assertNotNull(actualOrder.get().getId());

    assertThat(expectedEntity)
        .usingRecursiveComparison()
        .ignoringFields("id")
        .isEqualTo(actualOrder.get());
  }
}
