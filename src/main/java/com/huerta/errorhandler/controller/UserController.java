package com.huerta.errorhandler.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huerta.errorhandler.controller.assembler.UserAssembler;
import com.huerta.errorhandler.controller.assembler.UserResource;
import com.huerta.errorhandler.dto.UserDTO;
import com.huerta.errorhandler.entity.User;
import com.huerta.errorhandler.request.UserRequest;
import com.huerta.errorhandler.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  private final UserAssembler userAssembler;

  @GetMapping(value = "{id}")
  public ResponseEntity<UserResource> getById(@PathVariable final UUID id) {
    final UserDTO userDto = this.userService.getById(id);
    final UserResource userResource = this.userAssembler.toModel(userDto);
    return ResponseEntity.ok(userResource);
  }

  @GetMapping
  public ResponseEntity<CollectionModel<UserResource>> getAllUsers() {
    List<UserDTO> userDtoList = this.userService.getAll();
    CollectionModel<UserResource> userDtoCollectionModel =
      this.userAssembler.toCollectionModel(userDtoList);
    return ResponseEntity.ok(userDtoCollectionModel);
  }

  @PostMapping
  public ResponseEntity<User> postMethodName(
    @RequestBody UserRequest userRequest
  ) {
    return null;
  }
}
