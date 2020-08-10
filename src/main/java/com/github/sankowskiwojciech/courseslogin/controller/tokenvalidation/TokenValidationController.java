package com.github.sankowskiwojciech.courseslogin.controller.tokenvalidation;

import com.github.sankowskiwojciech.courseslogin.controller.tokenvalidation.validator.TokenValidationInputValidator;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationResponse;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TokenValidationController {

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/token/validate")
    public TokenValidationResponse validateToken(TokenValidationInput tokenValidationInput) {
        TokenValidationInputValidator.validateTokenValidationInput(tokenValidationInput);
        return new TokenValidationResponse(TokenValidationResult.VALID);
    }
}
