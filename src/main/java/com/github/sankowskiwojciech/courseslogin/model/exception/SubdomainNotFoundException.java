package com.github.sankowskiwojciech.courseslogin.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Subdomain with given name not found.")
public class SubdomainNotFoundException extends RuntimeException {
}
