package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.parent.ParentEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.student.StudentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PARENT_ID_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.STUDENT_ID_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<StudentEntity> studentEntities = testee.findAll();

        //then
        assertFalse(studentEntities.isEmpty());
    }

    @Test
    public void shouldFindStudentAndHisParentCorrectly() {
        //given
        long studentIdStub = STUDENT_ID_STUB;
        long parentIdStub = PARENT_ID_STUB;

        //when
        Optional<StudentEntity> studentEntityOptional = testee.findById(studentIdStub);

        //then
        assertTrue(studentEntityOptional.isPresent());
        StudentEntity studentEntity = studentEntityOptional.get();
        assertEquals(studentIdStub, studentEntity.getStudentId());
        ParentEntity parentEntity = studentEntity.getParent();
        assertNotNull(parentEntity);
        assertEquals(parentIdStub, parentEntity.getParentId());
    }
}