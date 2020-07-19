package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.RSA_PUBLIC_KEY_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TOKEN_VALUE_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenEntityStub {

    public static TokenEntity create() {
        return TokenEntity.builder()
                .id(UUID.randomUUID().toString())
                .tokenValue(TOKEN_VALUE_STUB)
                .emailAddress(EMAIL_ADDRESS_STUB)
                .rsaPublicKey(RSA_PUBLIC_KEY_STUB)
                .creationDateTime(LocalDateTime.now())
                .expirationDateTime(LocalDateTime.now().plusHours(1))
                .build();
    }
}
