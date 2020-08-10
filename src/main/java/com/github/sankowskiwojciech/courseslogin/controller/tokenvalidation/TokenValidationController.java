package com.github.sankowskiwojciech.courseslogin.controller.tokenvalidation;

import com.github.sankowskiwojciech.courseslogin.controller.tokenvalidation.validator.TokenValidationInputValidator;
import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidTokenException;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationResponse;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationResult;
import com.github.sankowskiwojciech.courseslogin.service.tokenvalidation.TokenValidationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TokenValidationController {

    private final TokenValidationService tokenValidationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/token/validate")
    public TokenValidationResponse validateToken(@RequestBody TokenValidationInput tokenValidationInput) {
        TokenValidationInputValidator.validateTokenValidationInput(tokenValidationInput);
        try {
            tokenValidationService.validateToken(tokenValidationInput);
        } catch (InvalidTokenException e) {
            return new TokenValidationResponse(TokenValidationResult.INVALID);
        }
        return new TokenValidationResponse(TokenValidationResult.VALID);
    }
}
