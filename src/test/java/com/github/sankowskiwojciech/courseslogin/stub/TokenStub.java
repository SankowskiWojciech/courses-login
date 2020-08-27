package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.account.AccountType;
import com.github.sankowskiwojciech.courseslogin.model.token.TokenResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TOKEN_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenStub {

    public static TokenResponse create() {
        return new TokenResponse(TOKEN_STUB, AccountType.TUTOR);
    }
}
