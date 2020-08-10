package com.github.sankowskiwojciech.courseslogin.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Token is invalid.")
public class InvalidTokenException extends RuntimeException {
}
