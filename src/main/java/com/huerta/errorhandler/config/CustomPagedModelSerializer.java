package com.huerta.errorhandler.config;

import java.io.IOException;

import org.springframework.hateoas.PagedModel;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomPagedModelSerializer extends StdSerializer<PagedModel<?>> {

  public CustomPagedModelSerializer() {
    this(null);
  }

  public CustomPagedModelSerializer(Class<PagedModel<?>> t) {
    super(t);
  }

  @Override
  public void serialize(
    PagedModel<?> value,
    JsonGenerator gen,
    SerializerProvider provider
  ) throws IOException {
    gen.writeStartObject();

    // Serialize page metadata
    gen.writeObjectField("page", value.getMetadata());

    // Serialize content
    gen.writeObjectField("data", value.getContent());

    // Serialize links
    gen.writeObjectField("links", value.getLinks());

    gen.writeEndObject();
  }

  @Override
  public Class<PagedModel<?>> handledType() {
    return (Class<PagedModel<?>>) (Class) PagedModel.class;
  }
}
