package com.github.sankowskiwojciech.courseslogin.service.token.transformer;

import com.github.sankowskiwojciech.coursescorelib.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.coursestestlib.stub.LoginCredentialsEntityStub;
import org.junit.Test;

import java.time.Duration;
import java.util.Base64;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.RSA_PUBLIC_KEY_BYTE_ARRAY_STUB;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LoginCredentialsEntityAndRsaPublicKeyToTokenEntityTest {
    private final LoginCredentialsEntityAndRsaPublicKeyToTokenEntity testee = LoginCredentialsEntityAndRsaPublicKeyToTokenEntity.getInstance();

    @Test
    public void shouldTransformCorrectly() {
        //given
        LoginCredentialsEntity loginCredentialsEntityStub = LoginCredentialsEntityStub.create();
        byte[] rsaPublicKey = RSA_PUBLIC_KEY_BYTE_ARRAY_STUB;

        //when
        TokenEntity tokenEntity = testee.apply(loginCredentialsEntityStub, rsaPublicKey);

        //then
        assertNotNull(tokenEntity);
        assertNotNull(tokenEntity.getTokenId());
        assertNull(tokenEntity.getTokenValue());
        assertEquals(loginCredentialsEntityStub.getUserEmailAddress(), tokenEntity.getUserEmailAddress());
        assertEquals(loginCredentialsEntityStub.getAccountType(), tokenEntity.getAccountType());
        assertEquals(Base64.getEncoder().encodeToString(rsaPublicKey), tokenEntity.getRsaPublicKey());
        assertNotNull(tokenEntity.getCreationDateTime());
        assertNotNull(tokenEntity.getExpirationDateTime());
        assertEquals(Duration.between(tokenEntity.getCreationDateTime(), tokenEntity.getExpirationDateTime()), Duration.ofHours(1));
        assertNull(tokenEntity.getRevocationDateTime());
    }
}