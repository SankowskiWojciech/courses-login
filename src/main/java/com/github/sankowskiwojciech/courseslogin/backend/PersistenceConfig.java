package com.github.sankowskiwojciech.courseslogin.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "jpa.properties")
public class PersistenceConfig {
}
