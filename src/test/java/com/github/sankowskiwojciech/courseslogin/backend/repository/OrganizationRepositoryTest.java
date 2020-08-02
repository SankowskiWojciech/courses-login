package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.organization.OrganizationEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_ALIAS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrganizationRepositoryTest {

    @Autowired
    private OrganizationRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<OrganizationEntity> organizationEntities = testee.findAll();

        //then
        assertFalse(organizationEntities.isEmpty());
    }

    @Test
    public void shouldFindEntityByAliasCorrectly() {
        //given
        String organizationAlias = ORGANIZATION_ALIAS;

        //when
        Optional<OrganizationEntity> organizationEntity = testee.findByAlias(organizationAlias);

        //then
        assertTrue(organizationEntity.isPresent());
    }
}