package com.huerta.errorhandler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class JacksonConfig {

  @Bean
  public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.modules(
      new SimpleModule().addSerializer(new CustomPagedModelSerializer())
    );
    return builder;
  }
}
