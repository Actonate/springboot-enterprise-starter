package com.accio.spring.starter.configs;


import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmptyMigrationStrategyConfig {

    /**
     * For disabled flyway migration on application startup.
     *
     *
     *
     * @return Flyway
     */
    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            // do nothing
        };
    }
}
