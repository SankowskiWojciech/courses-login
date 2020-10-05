package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.coursescorelib.model.account.AccountType;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TOKEN_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenResponseStub {

    public static TokenResponse create() {
        return new TokenResponse(TOKEN_STUB, AccountType.TUTOR, LocalDateTime.now().plusHours(1));
    }
}
