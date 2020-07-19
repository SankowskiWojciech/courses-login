package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.courseslogin.stub.TokenEntityStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TokenRepositoryTest {

    @Autowired
    private TokenRepository testee;

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        TokenEntity tokenEntityStub = TokenEntityStub.create();

        //when
        TokenEntity savedTokenEntity = testee.save(tokenEntityStub);

        //then
        assertEquals(tokenEntityStub, savedTokenEntity);
    }

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<TokenEntity> tokenEntities = testee.findAll();

        //then
        assertFalse(tokenEntities.isEmpty());
    }
}