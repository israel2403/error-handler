package com.huerta.errorhandler.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class FlywayConfig {

  private final DataSource dataSource;

  private static final Logger logger = LoggerFactory.getLogger(
    FlywayConfig.class
  );

  @Bean(initMethod = "migrate")
  public Flyway flyway() {
    logger.info("flywayConfigBean, {}", dataSource);
    return Flyway
      .configure()
      .dataSource(dataSource)
      .locations("classpath:db/migration")
      .baselineOnMigrate(true)
      .load();
  }
}
