package com.github.sankowskiwojciech.courseslogin.controller.tokenvalidation.validator;

import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidRequestBodyException;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenValidationInputValidator {

    public static void validateTokenValidationInput(TokenValidationInput tokenValidationInput) {
        if (tokenValidationInput == null || StringUtils.isBlank(tokenValidationInput.getTokenValue())) {
            throw new InvalidRequestBodyException();
        }
    }
}
