package com.github.sankowskiwojciech.courseslogin.service.subdomain;

import com.github.sankowskiwojciech.courseslogin.backend.repository.OrganizationRepository;
import com.github.sankowskiwojciech.courseslogin.backend.repository.TutorRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.courseslogin.model.exception.SubdomainNotFoundException;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.courseslogin.stub.OrganizationEntityStub;
import com.github.sankowskiwojciech.courseslogin.stub.TutorEntityStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_ALIAS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TUTOR_ALIAS_STUB;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SubdomainServiceImplTest {

    private final OrganizationRepository organizationRepositoryMock = mock(OrganizationRepository.class);
    private final TutorRepository tutorRepositoryMock = mock(TutorRepository.class);
    private final SubdomainService testee = new SubdomainServiceImpl(organizationRepositoryMock, tutorRepositoryMock);

    @Before
    public void reset() {
        Mockito.reset(organizationRepositoryMock, tutorRepositoryMock);
    }

    @Test(expected = SubdomainNotFoundException.class)
    public void shouldThrowSubdomainNotFoundExceptionWhenSubdomainDoesNotBelongToOrganizationOrTutor() {
        //given
        String subdomainName = UUID.randomUUID().toString();
        when(organizationRepositoryMock.findByAlias(eq(subdomainName))).thenReturn(Optional.empty());
        when(tutorRepositoryMock.findByAlias(eq(subdomainName))).thenReturn(Optional.empty());

        //when
        try {
            Subdomain subdomain = testee.readSubdomainIfExists(subdomainName);
        } catch (SubdomainNotFoundException e) {

            //then exception is thrown
            verify(organizationRepositoryMock).findByAlias(eq(subdomainName));
            verify(tutorRepositoryMock).findByAlias(eq(subdomainName));
            throw e;
        }
    }

    @Test
    public void shouldDoNothingWhenSubdomainBelongsToOrganization() {
        //given
        String subdomainName = ORGANIZATION_ALIAS_STUB;
        OrganizationEntity organizationEntityStub = OrganizationEntityStub.create();
        when(organizationRepositoryMock.findByAlias(eq(subdomainName))).thenReturn(Optional.of(organizationEntityStub));

        //when
        testee.readSubdomainIfExists(subdomainName);

        //then nothing happens
        verify(organizationRepositoryMock).findByAlias(eq(subdomainName));
    }

    @Test
    public void shouldDoNothingWhenSubdomainBelongsToTutor() {
        //given
        String subdomainName = TUTOR_ALIAS_STUB;
        TutorEntity tutorEntityStub = TutorEntityStub.create();
        when(organizationRepositoryMock.findByAlias(eq(subdomainName))).thenReturn(Optional.empty());
        when(tutorRepositoryMock.findByAlias(eq(subdomainName))).thenReturn(Optional.of(tutorEntityStub));

        //when
        testee.readSubdomainIfExists(subdomainName);

        //then nothing happens
        verify(organizationRepositoryMock).findByAlias(eq(subdomainName));
        verify(tutorRepositoryMock).findByAlias(eq(subdomainName));
    }
}