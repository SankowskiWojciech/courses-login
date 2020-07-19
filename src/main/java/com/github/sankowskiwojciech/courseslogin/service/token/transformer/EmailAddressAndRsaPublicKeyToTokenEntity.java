package com.github.sankowskiwojciech.courseslogin.service.token.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailAddressAndRsaPublicKeyToTokenEntity implements BiFunction<String, byte[], TokenEntity> {

    private static final EmailAddressAndRsaPublicKeyToTokenEntity INSTANCE = new EmailAddressAndRsaPublicKeyToTokenEntity();
    private static final long DEFAULT_TOKEN_VALIDITY_TIME_IN_HOURS = TimeUnit.HOURS.toHours(1);

    @Override
    public TokenEntity apply(String emailAddress, byte[] rsaPublicKey) {
        LocalDateTime creattionDateTime = LocalDateTime.now();
        return TokenEntity.builder()
                .id(UUID.randomUUID().toString())
                .emailAddress(emailAddress)
                .rsaPublicKey(Base64.getEncoder().encodeToString(rsaPublicKey))
                .creationDateTime(creattionDateTime)
                .expirationDateTime(creattionDateTime.plusHours(DEFAULT_TOKEN_VALIDITY_TIME_IN_HOURS))
                .build();
    }

    public static EmailAddressAndRsaPublicKeyToTokenEntity getInstance() {
        return INSTANCE;
    }
}
