package com.github.sankowskiwojciech.courseslogin.service.subdomain.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.SubdomainType;
import com.github.sankowskiwojciech.courseslogin.stub.TutorEntityStub;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TutorEntityToSubdomainTest {

    private final TutorEntityToSubdomain testee = TutorEntityToSubdomain.getInstance();

    @Test
    public void shouldTransformCorrectly() {
        //given
        TutorEntity tutorEntityStub = TutorEntityStub.create();

        //when
        Subdomain subdomain = testee.apply(tutorEntityStub);

        //then
        assertNotNull(subdomain);
        assertEquals(tutorEntityStub.getTutorId(), subdomain.getSubdomainId());
        assertEquals(SubdomainType.TUTOR, subdomain.getSubdomainType());
    }
}