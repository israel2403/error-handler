package com.huerta.errorhandler.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.huerta.errorhandler.dto.UserDTO;
import com.huerta.errorhandler.entity.User;
import com.huerta.errorhandler.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<UserDTO> getAll() {
    return this.userRepository.findAll()
      .stream()
      .map(UserDTO::new)
      .collect(Collectors.toList());
  }

  public UserDTO getById(final UUID id) {
    final User user = this.userRepository.findById(id).orElseThrow();
    return new UserDTO(user);
  }
}
