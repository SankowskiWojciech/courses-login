package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.coursescorelib.model.account.AccountType;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenEntity;
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
                .tokenId(UUID.randomUUID().toString())
                .tokenValue(TOKEN_VALUE_STUB)
                .userEmailAddress(EMAIL_ADDRESS_STUB)
                .accountType(AccountType.TUTOR)
                .rsaPublicKey(RSA_PUBLIC_KEY_STUB)
                .creationDateTime(LocalDateTime.now())
                .expirationDateTime(LocalDateTime.now().plusHours(1))
                .build();
    }

    public static TokenEntity create(LocalDateTime expirationDateTime, LocalDateTime revocationDateTime) {
        return TokenEntity.builder()
                .tokenId(UUID.randomUUID().toString())
                .tokenValue(TOKEN_VALUE_STUB)
                .userEmailAddress(EMAIL_ADDRESS_STUB)
                .accountType(AccountType.TUTOR)
                .rsaPublicKey(RSA_PUBLIC_KEY_STUB)
                .creationDateTime(expirationDateTime.minusHours(1))
                .expirationDateTime(expirationDateTime)
                .revocationDateTime(revocationDateTime)
                .build();
    }
}
