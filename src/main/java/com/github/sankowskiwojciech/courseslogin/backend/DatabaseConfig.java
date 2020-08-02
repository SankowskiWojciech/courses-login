package com.github.sankowskiwojciech.courseslogin.backend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "data-source.properties")
public class DatabaseConfig {

    @ConfigurationProperties(prefix = "data-source.postgres")
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
