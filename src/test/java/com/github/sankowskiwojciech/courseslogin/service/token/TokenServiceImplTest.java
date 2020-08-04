package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.backend.repository.TokenRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
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
    public void shouldGenerateJwsTokenCorrectly() {
        //given
        String emailAddress = EMAIL_ADDRESS_STUB;

        //when
        Token token = testee.generateToken(emailAddress);

        //then
        verify(tokenRepositoryMock).save(any(TokenEntity.class));

        assertNotNull(token);
        assertNotNull(token.getToken());
    }
}