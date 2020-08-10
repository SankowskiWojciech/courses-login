package com.github.sankowskiwojciech.courseslogin.model.tokenvalidation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokenValidationResponse {
    private TokenValidationResult validationResult;
}
