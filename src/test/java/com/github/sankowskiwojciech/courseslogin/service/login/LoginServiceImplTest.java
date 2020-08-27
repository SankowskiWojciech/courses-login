package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.backend.repository.LoginCredentialsRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.model.token.TokenResponse;
import com.github.sankowskiwojciech.courseslogin.service.password.PasswordService;
import com.github.sankowskiwojciech.courseslogin.service.subdomain.SubdomainService;
import com.github.sankowskiwojciech.courseslogin.service.token.TokenService;
import com.github.sankowskiwojciech.courseslogin.stub.LoginCredentialsEntityStub;
import com.github.sankowskiwojciech.courseslogin.stub.LoginCredentialsStub;
import com.github.sankowskiwojciech.courseslogin.stub.TokenResponseStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginServiceImplTest {

    private final LoginCredentialsRepository loginCredentialsRepositoryMock = mock(LoginCredentialsRepository.class);
    private final SubdomainService subdomainServiceMock = mock(SubdomainService.class);
    private final PasswordService passwordServiceMock = mock(PasswordService.class);
    private final TokenService tokenServiceMock = mock(TokenService.class);
    private final LoginService testee = new LoginServiceImpl(loginCredentialsRepositoryMock, passwordServiceMock, tokenServiceMock, subdomainServiceMock);

    @Before
    public void reset() {
        Mockito.reset(loginCredentialsRepositoryMock, subdomainServiceMock, passwordServiceMock, tokenServiceMock);
    }

    @Test
    public void shouldLoginUserCorrectly() {
        //given
        String subdomainEmailAddressStub = ORGANIZATION_EMAIL_ADDRESS_STUB;
        LoginCredentials loginCredentialsStub = LoginCredentialsStub.create();
        LoginCredentialsEntity loginCredentialsEntityStub = LoginCredentialsEntityStub.create();
        TokenResponse tokenResponseStub = TokenResponseStub.create();

        when(loginCredentialsRepositoryMock.findById(eq(loginCredentialsStub.getUserEmailAddress()))).thenReturn(Optional.of(loginCredentialsEntityStub));
        when(tokenServiceMock.generateToken(eq(loginCredentialsEntityStub))).thenReturn(tokenResponseStub);

        //when
        TokenResponse tokenResponse = testee.loginUserToSubdomain(subdomainEmailAddressStub, loginCredentialsStub);

        //then
        verify(loginCredentialsRepositoryMock).findById(eq(loginCredentialsStub.getUserEmailAddress()));
        verify(subdomainServiceMock).validateIfUserIsAllowedToLoginToSubdomain(eq(subdomainEmailAddressStub), eq(loginCredentialsEntityStub.getUserEmailAddress()));
        verify(passwordServiceMock).validatePassword(eq(loginCredentialsStub.getPassword()), eq(loginCredentialsEntityStub.getPasswordHash()));
        verify(tokenServiceMock).generateToken(eq(loginCredentialsEntityStub));

        assertNotNull(tokenResponse);
        assertEquals(tokenResponse, tokenResponseStub);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenUserWithGivenEmailAddressDoesNotExist() {
        //given
        String subdomainEmailAddressStub = ORGANIZATION_EMAIL_ADDRESS_STUB;
        LoginCredentials loginCredentialsStub = LoginCredentialsStub.create();

        when(loginCredentialsRepositoryMock.findById(eq(loginCredentialsStub.getUserEmailAddress()))).thenReturn(Optional.empty());

        //when
        try {
            testee.loginUserToSubdomain(subdomainEmailAddressStub, loginCredentialsStub);
        } catch (InvalidCredentialsException e) {

            //then exception is thrown
            verify(loginCredentialsRepositoryMock).findById(eq(loginCredentialsStub.getUserEmailAddress()));
            throw e;
        }
    }
}