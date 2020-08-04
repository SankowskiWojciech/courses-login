package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.account.AccountType;
import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TOKEN_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenStub {

    public static Token create() {
        return new Token(TOKEN_STUB, AccountType.TUTOR);
    }
}
