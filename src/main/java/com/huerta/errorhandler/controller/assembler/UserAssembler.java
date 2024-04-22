package com.huerta.errorhandler.controller.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.huerta.errorhandler.controller.UserController;
import com.huerta.errorhandler.dto.UserDTO;

@Component
public class UserAssembler
  implements RepresentationModelAssembler<UserDTO, UserResource> {

  @Override
  public UserResource toModel(UserDTO userDTO) {
    final UserResource userResource = new UserResource(userDTO);
    userResource.add(
      linkTo(methodOn(UserController.class).getById(userDTO.getId()))
        .withSelfRel()
    );
    return userResource;
  }

  @Override
  public CollectionModel<UserResource> toCollectionModel(
    Iterable<? extends UserDTO> entities
  ) {
    CollectionModel<UserResource> userResources = RepresentationModelAssembler.super.toCollectionModel(
      entities
    );

    // Add link to collection
    userResources.add(
      linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel()
    );

    return userResources;
  }
}
