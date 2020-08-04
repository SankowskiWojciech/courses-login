package com.github.sankowskiwojciech.courseslogin.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:jpa.properties")
public class PersistenceConfig {
}
