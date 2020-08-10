package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TOKEN_VALUE_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenValidationInputStub {

    public static TokenValidationInput createWithUserEmailAddress(String userEmailAddress) {
        return create(userEmailAddress, TOKEN_VALUE_STUB);
    }

    public static TokenValidationInput createWithTokenValue(String tokenValue) {
        return create(EMAIL_ADDRESS_STUB, tokenValue);
    }

    public static TokenValidationInput create(String userEmailAddress, String tokenValue) {
        return new TokenValidationInput(userEmailAddress, tokenValue);
    }

    public static TokenValidationInput create() {
        return new TokenValidationInput(EMAIL_ADDRESS_STUB, TOKEN_VALUE_STUB);
    }
}
