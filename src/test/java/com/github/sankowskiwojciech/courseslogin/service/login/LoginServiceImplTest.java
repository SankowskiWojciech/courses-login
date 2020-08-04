//package com.github.sankowskiwojciech.courseslogin.service.login;
//
//import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
//import com.github.sankowskiwojciech.courseslogin.model.token.Token;
//import com.github.sankowskiwojciech.courseslogin.service.password.PasswordService;
//import com.github.sankowskiwojciech.courseslogin.service.token.TokenService;
//import com.github.sankowskiwojciech.courseslogin.stub.JwsTokenStub;
//import com.github.sankowskiwojciech.courseslogin.stub.UserCredentialsStub;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class LoginServiceImplTest {
//
//    private final PasswordService passwordServiceMock = mock(PasswordService.class);
//    private final TokenService tokenServiceMock = mock(TokenService.class);
//    private final LoginService testee = new LoginServiceImpl(passwordServiceMock, tokenServiceMock);
//
//    @Before
//    public void reset() {
//        Mockito.reset(passwordServiceMock, tokenServiceMock);
//    }
//
//    @Test
//    public void shouldLoginUserCorrectly() {
//        //given
//        LoginCredentials loginCredentialsStub = UserCredentialsStub.create();
//        Token tokenStub = JwsTokenStub.create();
//
//        when(tokenServiceMock.generateJwsToken(eq(loginCredentialsStub.getEmailAddress()))).thenReturn(tokenStub);
//
//        //when
//        Token tokenResult = testee.loginUserToSubdomain(loginCredentialsStub);
//
//        //then
//        verify(passwordServiceMock).validatePassword(eq(loginCredentialsStub));
//        verify(tokenServiceMock).generateJwsToken(eq(loginCredentialsStub.getEmailAddress()));
//
//        assertNotNull(tokenResult);
//        assertEquals(tokenResult, tokenStub);
//    }
//}