package com.github.sankowskiwojciech.courseslogin.service.token.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.TokenResponse;
import com.github.sankowskiwojciech.courseslogin.util.LocalDateTimeToDate;
import io.jsonwebtoken.Jwts;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenEntityAndPrivateKeyToTokenResponse implements BiFunction<TokenEntity, PrivateKey, TokenResponse> {

    private static final TokenEntityAndPrivateKeyToTokenResponse INSTANCE = new TokenEntityAndPrivateKeyToTokenResponse();

    @Override
    public TokenResponse apply(TokenEntity tokenEntity, PrivateKey privateKey) {
        String jws = Jwts.builder()
                .setId(tokenEntity.getTokenId())
                .setSubject(tokenEntity.getUserEmailAddress())
                .setIssuedAt(LocalDateTimeToDate.getInstance().apply(tokenEntity.getCreationDateTime()))
                .setExpiration(LocalDateTimeToDate.getInstance().apply(tokenEntity.getExpirationDateTime()))
                .signWith(privateKey)
                .compact();
        return new TokenResponse(jws, tokenEntity.getAccountType());
    }

    public static TokenEntityAndPrivateKeyToTokenResponse getInstance() {
        return INSTANCE;
    }
}
