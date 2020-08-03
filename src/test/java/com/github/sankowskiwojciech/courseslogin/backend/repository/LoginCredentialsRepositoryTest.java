package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoginCredentialsRepositoryTest {

    @Autowired
    private LoginCredentialsRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<LoginCredentialsEntity> loginCredentialsEntities = testee.findAll();

        //then
        assertFalse(loginCredentialsEntities.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenEntityExistsByEmailAddress() {
        //given
        String emailAddressStub = EMAIL_ADDRESS_STUB;

        //when
        Optional<LoginCredentialsEntity> loginCredentialsEntity = testee.findByEmailAddress(emailAddressStub);

        //then
        assertTrue(loginCredentialsEntity.isPresent());
    }
}