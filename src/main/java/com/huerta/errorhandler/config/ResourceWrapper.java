package com.huerta.errorhandler.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceWrapper<T> {

  @JsonProperty("type")
  private String type;

  @JsonProperty("id")
  private String id;

  @JsonProperty("attributes")
  private T attributes;
}
