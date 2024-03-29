package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.coursescorelib.backend.repository.LoginCredentialsRepository;
import com.github.sankowskiwojciech.coursescorelib.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenResponse;
import com.github.sankowskiwojciech.coursescorelib.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.coursescorelib.model.login.LoginCredentials;
import com.github.sankowskiwojciech.coursescorelib.service.subdomain.SubdomainService;
import com.github.sankowskiwojciech.courseslogin.service.password.PasswordService;
import com.github.sankowskiwojciech.courseslogin.service.token.TokenService;
import com.github.sankowskiwojciech.coursestestlib.stub.LoginCredentialsEntityStub;
import com.github.sankowskiwojciech.coursestestlib.stub.LoginCredentialsStub;
import com.github.sankowskiwojciech.coursestestlib.stub.TokenResponseStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.ORGANIZATION_ALIAS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        String subdomainAliasStub = ORGANIZATION_ALIAS_STUB;
        LoginCredentials loginCredentialsStub = LoginCredentialsStub.create();
        LoginCredentialsEntity loginCredentialsEntityStub = LoginCredentialsEntityStub.create();
        TokenResponse tokenResponseStub = TokenResponseStub.create();

        when(loginCredentialsRepositoryMock.findById(loginCredentialsStub.getUserEmailAddress())).thenReturn(Optional.of(loginCredentialsEntityStub));
        when(tokenServiceMock.generateToken(loginCredentialsEntityStub)).thenReturn(tokenResponseStub);

        //when
        TokenResponse tokenResponse = testee.loginUserToSubdomain(subdomainAliasStub, loginCredentialsStub);

        //then
        verify(loginCredentialsRepositoryMock).findById(loginCredentialsStub.getUserEmailAddress());
        verify(subdomainServiceMock).validateIfUserHasAccessToSubdomain(subdomainAliasStub, loginCredentialsEntityStub.getUserEmailAddress());
        verify(passwordServiceMock).validatePassword(loginCredentialsStub.getPassword(), loginCredentialsEntityStub.getPasswordHash());
        verify(tokenServiceMock).generateToken(loginCredentialsEntityStub);

        assertNotNull(tokenResponse);
        assertEquals(tokenResponse, tokenResponseStub);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenUserWithGivenEmailAddressDoesNotExist() {
        //given
        String subdomainAliasStub = ORGANIZATION_ALIAS_STUB;
        LoginCredentials loginCredentialsStub = LoginCredentialsStub.create();

        when(loginCredentialsRepositoryMock.findById(loginCredentialsStub.getUserEmailAddress())).thenReturn(Optional.empty());

        //when
        try {
            testee.loginUserToSubdomain(subdomainAliasStub, loginCredentialsStub);
        } catch (InvalidCredentialsException e) {

            //then exception is thrown
            verify(loginCredentialsRepositoryMock).findById(loginCredentialsStub.getUserEmailAddress());
            throw e;
        }
    }
}