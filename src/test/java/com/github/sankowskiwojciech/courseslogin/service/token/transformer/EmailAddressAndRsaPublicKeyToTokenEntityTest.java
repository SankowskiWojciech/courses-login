package com.github.sankowskiwojciech.courseslogin.service.token.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import org.junit.Test;

import java.time.Duration;
import java.util.Base64;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.RSA_PUBLIC_KEY_BYTE_ARRAY_STUB;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmailAddressAndRsaPublicKeyToTokenEntityTest {

    private final EmailAddressAndRsaPublicKeyToTokenEntity testee = EmailAddressAndRsaPublicKeyToTokenEntity.getInstance();

    @Test
    public void shouldTransformCorrectly() {
        //given
        String emailAddress = EMAIL_ADDRESS_STUB;
        byte[] rsaPublicKey = RSA_PUBLIC_KEY_BYTE_ARRAY_STUB;

        //when
        TokenEntity tokenEntity = testee.apply(emailAddress, rsaPublicKey);

        //then
        assertNotNull(tokenEntity);
        assertNotNull(tokenEntity.getId());
        assertNull(tokenEntity.getTokenValue());
        assertEquals(emailAddress, tokenEntity.getEmailAddress());
        assertEquals(Base64.getEncoder().encodeToString(rsaPublicKey), tokenEntity.getRsaPublicKey());
        assertNotNull(tokenEntity.getCreationDateTime());
        assertNotNull(tokenEntity.getExpirationDateTime());
        assertEquals(Duration.between(tokenEntity.getCreationDateTime(), tokenEntity.getExpirationDateTime()), Duration.ofHours(1));
        assertFalse(tokenEntity.isRevoked());
        assertNull(tokenEntity.getRevocationDateTime());
        ;
    }
}