package com.github.sankowskiwojciech.courseslogin.service.tokenvalidation;

import com.github.sankowskiwojciech.courseslogin.backend.repository.TokenRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidTokenException;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;
import com.github.sankowskiwojciech.courseslogin.stub.TokenEntityStub;
import com.github.sankowskiwojciech.courseslogin.stub.TokenValidationInputStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_EMAIL_ADDRESS_STUB;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TokenValidationServiceImplTest {

    private final TokenRepository tokenRepositoryMock = mock(TokenRepository.class);
    private final TokenValidationService testee = new TokenValidationServiceImpl(tokenRepositoryMock);

    @Before
    public void reset() {
        Mockito.reset(tokenRepositoryMock);
    }

    @Test(expected = InvalidTokenException.class)
    public void shouldThrowInvalidTokenExceptionWhenTokenIsNotFound() {
        //given
        TokenValidationInput tokenValidationInputStub = TokenValidationInputStub.create();
        when(tokenRepositoryMock.findByTokenValue(eq(tokenValidationInputStub.getTokenValue()))).thenReturn(Optional.empty());

        //when
        try {
            testee.validateToken(tokenValidationInputStub);
        } catch (InvalidTokenException e) {

            //then exception is thrown
            verify(tokenRepositoryMock).findByTokenValue(eq(tokenValidationInputStub.getTokenValue()));
            throw e;
        }
    }

    @Test(expected = InvalidTokenException.class)
    public void shouldThrowInvalidTokenExceptionWhenTokenIsNotIssuedForProvidedUser() {
        //given
        TokenValidationInput tokenValidationInputStub = TokenValidationInputStub.create();
        TokenEntity tokenEntityStub = TokenEntityStub.create(ORGANIZATION_EMAIL_ADDRESS_STUB, LocalDateTime.now().plusHours(1), null);
        when(tokenRepositoryMock.findByTokenValue(eq(tokenValidationInputStub.getTokenValue()))).thenReturn(Optional.of(tokenEntityStub));

        //when
        try {
            testee.validateToken(tokenValidationInputStub);
        } catch (InvalidTokenException e) {

            //then exception is thrown
            verify(tokenRepositoryMock).findByTokenValue(eq(tokenValidationInputStub.getTokenValue()));
            throw e;
        }
    }

    @Test(expected = InvalidTokenException.class)
    public void shouldThrowInvalidTokenExceptionWhenTokenIsRevoked() {
        //given
        TokenValidationInput tokenValidationInputStub = TokenValidationInputStub.create();
        TokenEntity tokenEntityStub = TokenEntityStub.create(tokenValidationInputStub.getUserEmailAddress(), LocalDateTime.now().plusHours(1), LocalDateTime.now());
        when(tokenRepositoryMock.findByTokenValue(eq(tokenValidationInputStub.getTokenValue()))).thenReturn(Optional.of(tokenEntityStub));

        //when
        try {
            testee.validateToken(tokenValidationInputStub);
        } catch (InvalidTokenException e) {

            //then exception is thrown
            verify(tokenRepositoryMock).findByTokenValue(eq(tokenValidationInputStub.getTokenValue()));
            throw e;
        }
    }

    @Test(expected = InvalidTokenException.class)
    public void shouldThrowInvalidTokenExceptionWhenTokenIsExpired() {
        //given
        TokenValidationInput tokenValidationInputStub = TokenValidationInputStub.create();
        TokenEntity tokenEntityStub = TokenEntityStub.create(tokenValidationInputStub.getUserEmailAddress(), LocalDateTime.now().minusHours(1), null);
        when(tokenRepositoryMock.findByTokenValue(eq(tokenValidationInputStub.getTokenValue()))).thenReturn(Optional.of(tokenEntityStub));

        //when
        try {
            testee.validateToken(tokenValidationInputStub);
        } catch (InvalidTokenException e) {

            //then exception is thrown
            verify(tokenRepositoryMock).findByTokenValue(eq(tokenValidationInputStub.getTokenValue()));
            throw e;
        }
    }

    @Test
    public void shouldDoNothingWhenTokenIsValid() {
        //given
        TokenValidationInput tokenValidationInputStub = TokenValidationInputStub.create();
        TokenEntity tokenEntityStub = TokenEntityStub.create(tokenValidationInputStub.getUserEmailAddress(), LocalDateTime.now().plusHours(1), null);
        when(tokenRepositoryMock.findByTokenValue(eq(tokenValidationInputStub.getTokenValue()))).thenReturn(Optional.of(tokenEntityStub));

        //when
        testee.validateToken(tokenValidationInputStub);

        //then nothing happens
        verify(tokenRepositoryMock).findByTokenValue(eq(tokenValidationInputStub.getTokenValue()));
    }
}