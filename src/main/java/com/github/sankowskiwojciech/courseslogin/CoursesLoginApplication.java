package com.github.sankowskiwojciech.courseslogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class CoursesLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursesLoginApplication.class, args);
    }

}
