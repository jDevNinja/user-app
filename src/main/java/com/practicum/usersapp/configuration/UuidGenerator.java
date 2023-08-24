package com.practicum.usersapp.configuration;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UuidGenerator {

  public String nextUuid() {
    return UUID.randomUUID().toString();
  }
}
