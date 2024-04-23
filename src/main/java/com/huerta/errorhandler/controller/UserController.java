package com.huerta.errorhandler.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huerta.errorhandler.controller.assembler.UserAssembler;
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
  public ResponseEntity<EntityModel<UserDTO>> getById(
    @PathVariable final UUID id
  ) {
    final UserDTO userDto = this.userService.getById(id);
    // Convert the user into an EntityModel
    EntityModel<UserDTO> userEntityModel = userAssembler.toModel(userDto);
    return ResponseEntity.ok(userEntityModel);
  }

  @GetMapping
  public ResponseEntity<PagedModel<UserDTO>> getAllUsers(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "5") int size
  ) {
    List<UserDTO> userDtoList = this.userService.getAll();
    Pageable pageable = PageRequest.of(page, size);
    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), userDtoList.size());

    Page<UserDTO> userPage = new PageImpl<>(
      userDtoList.subList(start, end),
      pageable,
      userDtoList.size()
    );

    PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
      userPage.getSize(),
      userPage.getNumber(),
      userPage.getTotalPages(),
      userPage.getTotalElements()
    );

    final List<Link> links = new ArrayList();

    links.add(
      linkTo(methodOn(UserController.class).getAllUsers(0, size))
        .withRel("first")
    );

    // Add pagination links
    if (userPage.hasPrevious()) {
      links.add(
        linkTo(methodOn(UserController.class).getAllUsers(page - 1, size))
          .withRel("prev")
      );
    }
    links.add(
      linkTo(methodOn(UserController.class).getAllUsers(page, size))
        .withRel("self")
    );
    if (userPage.hasNext()) {
      links.add(
        linkTo(methodOn(UserController.class).getAllUsers(page + 1, size))
          .withRel("next")
      );
    }

    links.add(
      linkTo(
        methodOn(UserController.class)
          .getAllUsers(userPage.getTotalPages() - 1, size)
      )
        .withRel("last")
    );
    PagedModel<UserDTO> pagedModel = PagedModel.of(
      userPage.getContent(),
      metadata,
      links
    );
    return ResponseEntity.ok(pagedModel);
  }

  @PostMapping
  public ResponseEntity<User> postMethodName(
    @RequestBody UserRequest userRequest
  ) {
    return null;
  }

  private void addPaginationLinks(
    CollectionModel<?> collectionModel,
    int currentPage,
    int totalUsers
  ) {
    int pageSize = 10;
    int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
    int nextPage = currentPage + 1;
    int previousPage = currentPage - 1;

    // Add first link
    if (currentPage > 0) {
      collectionModel.add(Link.of("/api/users?page=0", "first"));
    }

    // Add previous link
    if (currentPage > 0) {
      collectionModel.add(
        Link.of("/api/users?page=" + previousPage, "previous")
      );
    }

    // Add next link
    if (currentPage < totalPages - 1) {
      collectionModel.add(Link.of("/api/users?page=" + nextPage, "next"));
    }

    // Add last link
    if (currentPage < totalPages - 1) {
      collectionModel.add(
        Link.of("/api/users?page=" + (totalPages - 1), "last")
      );
    }
  }
}
