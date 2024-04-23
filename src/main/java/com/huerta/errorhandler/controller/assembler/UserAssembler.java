package com.huerta.errorhandler.controller.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.huerta.errorhandler.dto.UserDTO;

@Component
public class UserAssembler
  implements RepresentationModelAssembler<UserDTO, EntityModel<UserDTO>> {

  @Override
  public EntityModel<UserDTO> toModel(UserDTO userDTO) {
    return EntityModel.of(userDTO);
  }

  public CollectionModel<EntityModel<UserDTO>> toCollectionModel(
    final List<UserDTO> entities
  ) {
    List<EntityModel<UserDTO>> entityModels = entities
      .stream()
      .map(this::toModel)
      .collect(Collectors.toList());
    // Create CollectionModel with links

    return CollectionModel.of(entityModels);
  }
}
