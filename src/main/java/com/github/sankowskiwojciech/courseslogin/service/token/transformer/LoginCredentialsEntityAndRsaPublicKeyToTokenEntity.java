package com.github.sankowskiwojciech.courseslogin.service.token.transformer;

import com.github.sankowskiwojciech.coursescorelib.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginCredentialsEntityAndRsaPublicKeyToTokenEntity implements BiFunction<LoginCredentialsEntity, byte[], TokenEntity> {

    private static final LoginCredentialsEntityAndRsaPublicKeyToTokenEntity INSTANCE = new LoginCredentialsEntityAndRsaPublicKeyToTokenEntity();

    private static final long DEFAULT_TOKEN_VALIDITY_TIME_IN_HOURS = TimeUnit.HOURS.toHours(1);

    @Override
    public TokenEntity apply(LoginCredentialsEntity loginCredentialsEntity, byte[] rsaPublicKey) {
        LocalDateTime creationDateTime = LocalDateTime.now();
        return TokenEntity.builder()
                .tokenId(UUID.randomUUID().toString())
                .userEmailAddress(loginCredentialsEntity.getUserEmailAddress())
                .accountType(loginCredentialsEntity.getAccountType())
                .rsaPublicKey(Base64.getEncoder().encodeToString(rsaPublicKey))
                .creationDateTime(creationDateTime)
                .expirationDateTime(creationDateTime.plusHours(DEFAULT_TOKEN_VALIDITY_TIME_IN_HOURS))
                .build();
    }

    public static LoginCredentialsEntityAndRsaPublicKeyToTokenEntity getInstance() {
        return INSTANCE;
    }
}
