package com.github.sankowskiwojciech.courseslogin.registration;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncoderServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordEncoderServiceTest.class);
    private final PasswordEncoderService testee = new PasswordEncoderService(new BCryptPasswordEncoder(15));

    @Test
    public void shouldEncodePlainPasswordCorrectly() {
        //given
        String password = "test";

        //when
        String encodedPassword = testee.encodePassword(password);

        //then
        LOG.info(String.format("Plain password: %s\tEncoded password: %s", password, encodedPassword));
        assertTrue(testee.validatePassword(password, encodedPassword));
    }
}
