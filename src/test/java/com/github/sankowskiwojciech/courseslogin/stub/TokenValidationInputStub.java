package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TOKEN_VALUE_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenValidationInputStub {

    public static TokenValidationInput createWithTokenValue(String tokenValue) {
        return new TokenValidationInput(tokenValue);
    }

    public static TokenValidationInput create() {
        return new TokenValidationInput(TOKEN_VALUE_STUB);
    }
}
