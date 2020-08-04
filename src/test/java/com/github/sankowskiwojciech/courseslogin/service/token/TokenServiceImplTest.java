package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.backend.repository.TokenRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import com.github.sankowskiwojciech.courseslogin.stub.LoginCredentialsEntityStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TokenServiceImplTest {

    private final TokenRepository tokenRepositoryMock = mock(TokenRepository.class);
    private final TokenService testee = new TokenServiceImpl(tokenRepositoryMock);

    @Before
    public void reset() {
        Mockito.reset(tokenRepositoryMock);
    }

    @Test
    public void shouldGenerateTokenCorrectly() {
        //given
        LoginCredentialsEntity loginCredentialsEntityStub = LoginCredentialsEntityStub.create();

        //when
        Token token = testee.generateToken(loginCredentialsEntityStub);

        //then
        verify(tokenRepositoryMock).save(any(TokenEntity.class));

        assertNotNull(token);
        assertNotNull(token.getTokenValue());
        assertEquals(loginCredentialsEntityStub.getAccountType(), token.getAccountType());
    }
}