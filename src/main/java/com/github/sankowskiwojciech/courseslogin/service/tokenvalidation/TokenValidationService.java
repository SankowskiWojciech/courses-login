package com.github.sankowskiwojciech.courseslogin.service.tokenvalidation;

import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;

public interface TokenValidationService {

    void validateToken(TokenValidationInput tokenValidationInput);
}
