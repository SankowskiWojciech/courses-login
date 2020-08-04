package com.github.sankowskiwojciech.courseslogin.service.token.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import com.github.sankowskiwojciech.courseslogin.util.LocalDateTimeToDate;
import io.jsonwebtoken.Jwts;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenEntityAndPrivateKeyToJwsToken implements BiFunction<TokenEntity, PrivateKey, Token> {

    private static final TokenEntityAndPrivateKeyToJwsToken INSTANCE = new TokenEntityAndPrivateKeyToJwsToken();

    @Override
    public Token apply(TokenEntity tokenEntity, PrivateKey privateKey) {
        String jws = Jwts.builder()
                .setId(tokenEntity.getId())
                .setSubject(tokenEntity.getEmailAddress())
                .setIssuedAt(LocalDateTimeToDate.getInstance().apply(tokenEntity.getCreationDateTime()))
                .setExpiration(LocalDateTimeToDate.getInstance().apply(tokenEntity.getExpirationDateTime()))
                .signWith(privateKey)
                .compact();
        return new Token(jws);
    }

    public static TokenEntityAndPrivateKeyToJwsToken getInstance() {
        return INSTANCE;
    }
}
