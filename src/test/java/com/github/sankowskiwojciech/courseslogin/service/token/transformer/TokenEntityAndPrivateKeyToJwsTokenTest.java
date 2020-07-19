package com.github.sankowskiwojciech.courseslogin.service.token.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.JwsToken;
import com.github.sankowskiwojciech.courseslogin.stub.KeyPairStub;
import com.github.sankowskiwojciech.courseslogin.stub.TokenEntityStub;
import com.github.sankowskiwojciech.courseslogin.util.DateToLocalDateTime;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TokenEntityAndPrivateKeyToJwsTokenTest {

    private final TokenEntityAndPrivateKeyToJwsToken testee = TokenEntityAndPrivateKeyToJwsToken.getInstance();

    @Test
    public void shouldTransformCorrectly() {
        //given
        TokenEntity tokenEntityStub = TokenEntityStub.create();
        KeyPair keyPair = KeyPairStub.create();

        //when
        JwsToken jwsToken = testee.apply(tokenEntityStub, keyPair.getPrivate());

        //then
        assertNotNull(jwsToken);
        assertNotNull(jwsToken.getToken());
        Jws<Claims> parsedJws = parseJws(jwsToken.getToken(), keyPair.getPublic());
        assertParsedJws(parsedJws.getBody(), tokenEntityStub);
    }

    private Jws<Claims> parseJws(String jws, PublicKey publicKey) {
        return Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(jws);
    }

    private void assertParsedJws(Claims parsedJwsBody, TokenEntity tokenEntity) {
        assertEquals(tokenEntity.getId(), parsedJwsBody.getId());
        assertEquals(tokenEntity.getEmailAddress(), parsedJwsBody.getSubject());
        assertEquals(tokenEntity.getCreationDateTime().withNano(0), DateToLocalDateTime.getInstance().apply(parsedJwsBody.getIssuedAt()));
        assertEquals(tokenEntity.getExpirationDateTime().withNano(0), DateToLocalDateTime.getInstance().apply(parsedJwsBody.getExpiration()));
    }
}