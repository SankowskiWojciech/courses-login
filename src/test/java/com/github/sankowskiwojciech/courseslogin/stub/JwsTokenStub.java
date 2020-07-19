package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.token.JwsToken;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.JWS_TOKEN_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwsTokenStub {

    public static JwsToken create() {
        return new JwsToken(JWS_TOKEN_STUB);
    }
}
