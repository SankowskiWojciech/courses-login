package com.github.sankowskiwojciech.courseslogin.service.token.transformer;

import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenResponse;
import com.github.sankowskiwojciech.coursescorelib.util.DateToLocalDateTime;
import com.github.sankowskiwojciech.courseslogin.stub.KeyPairStub;
import com.github.sankowskiwojciech.coursestestlib.stub.TokenEntityStub;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TokenEntityAndPrivateKeyToTokenResponseTest {
    private final TokenEntityAndPrivateKeyToTokenResponse testee = TokenEntityAndPrivateKeyToTokenResponse.getInstance();

    @Test
    public void shouldTransformCorrectly() {
        //given
        TokenEntity tokenEntityStub = TokenEntityStub.create();
        KeyPair keyPair = KeyPairStub.create();

        //when
        TokenResponse tokenResponse = testee.apply(tokenEntityStub, keyPair.getPrivate());

        //then
        assertNotNull(tokenResponse);
        assertNotNull(tokenResponse.getTokenValue());
        assertEquals(tokenEntityStub.getAccountType(), tokenResponse.getAccountType());
        Jws<Claims> parsedJws = parseJws(tokenResponse.getTokenValue(), keyPair.getPublic());
        assertParsedJws(parsedJws.getBody(), tokenEntityStub);
    }

    private Jws<Claims> parseJws(String jws, PublicKey publicKey) {
        return Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(jws);
    }

    private void assertParsedJws(Claims parsedJwsBody, TokenEntity tokenEntity) {
        assertEquals(tokenEntity.getTokenId(), parsedJwsBody.getId());
        assertEquals(tokenEntity.getUserEmailAddress(), parsedJwsBody.getSubject());
        assertEquals(tokenEntity.getCreationDateTime().withNano(0), DateToLocalDateTime.getInstance().apply(parsedJwsBody.getIssuedAt()));
        assertEquals(tokenEntity.getExpirationDateTime().withNano(0), DateToLocalDateTime.getInstance().apply(parsedJwsBody.getExpiration()));
    }
}