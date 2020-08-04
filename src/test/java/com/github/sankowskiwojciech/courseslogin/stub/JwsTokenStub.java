package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.JWS_TOKEN_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwsTokenStub {

    public static Token create() {
        return new Token(JWS_TOKEN_STUB);
    }
}
