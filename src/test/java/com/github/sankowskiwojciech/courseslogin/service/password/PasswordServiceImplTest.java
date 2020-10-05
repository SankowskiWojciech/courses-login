package com.github.sankowskiwojciech.courseslogin.service.password;

import com.github.sankowskiwojciech.coursescorelib.model.exception.InvalidCredentialsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.INVALID_PASSWORD_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_HASH_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_STUB;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PasswordServiceImplTest {

    private final PasswordEncoder passwordEncoderMock = mock(PasswordEncoder.class);
    private final PasswordService testee = new PasswordServiceImpl(passwordEncoderMock);

    @Before
    public void reset() {
        Mockito.reset(passwordEncoderMock);
    }

    @Test
    public void shouldReturnPasswordHashCorrectly() {
        //given
        String passwordStub = UUID.randomUUID().toString();
        String passwordHashStub = UUID.randomUUID().toString();
        when(passwordEncoderMock.encode(eq(passwordStub))).thenReturn(passwordHashStub);

        //when
        String encodedPasswordResult = testee.createPasswordHash(passwordStub);

        //then
        verify(passwordEncoderMock).encode(eq(passwordStub));
        assertEquals(passwordHashStub, encodedPasswordResult);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenPasswordIsNotValid() {
        //given
        boolean passwordMatches = false;
        String passwordFromRequest = PASSWORD_STUB;
        String passwordHashStub = INVALID_PASSWORD_STUB;

        when(passwordEncoderMock.matches(anyString(), anyString())).thenReturn(passwordMatches);

        //when
        try {
            testee.validatePassword(passwordFromRequest, passwordHashStub);
        } catch (InvalidCredentialsException e) {

            //then exception is thrown
            verify(passwordEncoderMock).matches(anyString(), anyString());
            throw e;
        }
    }

    @Test
    public void shouldDoNothingWhenPasswordIsValid() {
        //given
        boolean passwordMatches = true;
        String passwordFromRequest = PASSWORD_STUB;
        String passwordHashStub = PASSWORD_HASH_STUB;

        when(passwordEncoderMock.matches(anyString(), anyString())).thenReturn(passwordMatches);

        //when
        testee.validatePassword(passwordFromRequest, passwordHashStub);

        //then nothing happens
        verify(passwordEncoderMock).matches(anyString(), anyString());
    }
}