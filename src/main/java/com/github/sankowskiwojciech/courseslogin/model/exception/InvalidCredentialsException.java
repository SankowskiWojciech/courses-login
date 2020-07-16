package com.github.sankowskiwojciech.courseslogin.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Address email or password is incorrect.")
public class InvalidCredentialsException extends RuntimeException {
}
