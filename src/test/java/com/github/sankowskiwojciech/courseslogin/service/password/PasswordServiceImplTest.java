package com.github.sankowskiwojciech.courseslogin.service.password;

import com.github.sankowskiwojciech.courseslogin.backend.repository.UserCredentialsRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.user.UserCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import com.github.sankowskiwojciech.courseslogin.stub.UserCredentialsEntityStub;
import com.github.sankowskiwojciech.courseslogin.stub.UserCredentialsStub;
import org.hibernate.graph.InvalidGraphException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_STUB;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PasswordServiceImplTest {

    private final PasswordEncoder passwordEncoderMock = mock(PasswordEncoder.class);
    private final UserCredentialsRepository userCredentialsRepositoryMock = mock(UserCredentialsRepository.class);
    private final PasswordService testee = new PasswordServiceImpl(passwordEncoderMock, userCredentialsRepositoryMock);

    @Before
    public void reset() {
        Mockito.reset(passwordEncoderMock, userCredentialsRepositoryMock);
    }

    @Test
    public void shouldEncodePasswordCorrectly() {
        //given
        String passwordStub = UUID.randomUUID().toString();
        String encodedPasswordStub = UUID.randomUUID().toString();
        when(passwordEncoderMock.encode(eq(passwordStub))).thenReturn(encodedPasswordStub);

        //when
        String encodedPasswordResult = testee.encodePassword(passwordStub);

        //then
        verify(passwordEncoderMock).encode(eq(passwordStub));
        assertEquals(new String(Base64.getEncoder().encode(encodedPasswordStub.getBytes())), encodedPasswordResult);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenUserWithGivenEmailAddressIsNotFound() {
        //given
        String emailAddressStub = EMAIL_ADDRESS_STUB;
        UserCredentials userCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(emailAddressStub, PASSWORD_STUB);
        when(userCredentialsRepositoryMock.findById(eq(emailAddressStub))).thenReturn(Optional.empty());

        //when
        try {
            testee.validatePassword(userCredentialsStub);
        } catch (InvalidGraphException e) {
            verify(userCredentialsRepositoryMock).findById(eq(emailAddressStub));
            throw e;
        }

        //then exception is thrown
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenPasswordIsNotValid() {
        //given
        boolean passwordMatches = false;
        String emailAddressStub = EMAIL_ADDRESS_STUB;
        UserCredentials userCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(emailAddressStub, PASSWORD_STUB);
        UserCredentialsEntity userCredentialsEntityStub = UserCredentialsEntityStub.createWithAddressEmailAndPassword(emailAddressStub, PASSWORD_STUB);
        when(userCredentialsRepositoryMock.findById(eq(emailAddressStub))).thenReturn(Optional.of(userCredentialsEntityStub));
        when(passwordEncoderMock.matches(eq(userCredentialsStub.getPassword()), anyString())).thenReturn(passwordMatches);

        //when
        try {
            testee.validatePassword(userCredentialsStub);
        } catch (InvalidGraphException e) {
            verify(userCredentialsRepositoryMock).findById(eq(emailAddressStub));
            verify(passwordEncoderMock).matches(eq(userCredentialsStub.getPassword()), anyString());
            throw e;
        }

        //then exception is thrown
    }

    @Test
    public void shouldDoNothingWhenPasswordIsValid() {
        //given
        boolean passwordMatches = true;
        String emailAddressStub = EMAIL_ADDRESS_STUB;
        UserCredentials userCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(emailAddressStub, PASSWORD_STUB);
        UserCredentialsEntity userCredentialsEntityStub = UserCredentialsEntityStub.createWithAddressEmailAndPassword(emailAddressStub, PASSWORD_STUB);
        when(userCredentialsRepositoryMock.findById(eq(emailAddressStub))).thenReturn(Optional.of(userCredentialsEntityStub));
        when(passwordEncoderMock.matches(eq(userCredentialsStub.getPassword()), anyString())).thenReturn(passwordMatches);

        //when
        testee.validatePassword(userCredentialsStub);

        //then nothing happens
        verify(userCredentialsRepositoryMock).findById(eq(emailAddressStub));
        verify(passwordEncoderMock).matches(eq(userCredentialsStub.getPassword()), anyString());
    }
}