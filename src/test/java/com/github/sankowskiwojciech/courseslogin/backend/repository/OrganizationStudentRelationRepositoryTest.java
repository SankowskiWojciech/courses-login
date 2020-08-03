package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.relations.OrganizationStudentRelationEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrganizationStudentRelationRepositoryTest {

    @Autowired
    private OrganizationStudentRelationRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<OrganizationStudentRelationEntity> organizationStudentRelationEntities = testee.findAll();

        //then
        assertFalse(organizationStudentRelationEntities.isEmpty());
    }
}