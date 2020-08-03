package com.github.sankowskiwojciech.courseslogin.service.subdomain;

import com.github.sankowskiwojciech.courseslogin.backend.repository.OrganizationRepository;
import com.github.sankowskiwojciech.courseslogin.backend.repository.OrganizationStudentRelationRepository;
import com.github.sankowskiwojciech.courseslogin.backend.repository.OrganizationTutorRelationRepository;
import com.github.sankowskiwojciech.courseslogin.backend.repository.StudentRepository;
import com.github.sankowskiwojciech.courseslogin.backend.repository.TutorRepository;
import com.github.sankowskiwojciech.courseslogin.backend.repository.TutorStudentRelationRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.courseslogin.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.courseslogin.model.exception.SubdomainNotFoundException;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.courseslogin.service.subdomain.transformer.OrganizationEntityToSubdomain;
import com.github.sankowskiwojciech.courseslogin.service.subdomain.transformer.TutorEntityToSubdomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SubdomainServiceImpl implements SubdomainService {

    private final OrganizationRepository organizationRepository;
    private final TutorRepository tutorRepository;
    private final StudentRepository studentRepository;
    private final OrganizationStudentRelationRepository organizationStudentRelationRepository;
    private final OrganizationTutorRelationRepository organizationTutorRelationRepository;
    private final TutorStudentRelationRepository tutorStudentRelationRepository;

    @Override
    public Subdomain readSubdomainIfExists(String subdomainName) {
        Optional<OrganizationEntity> organizationEntity = organizationRepository.findByAlias(subdomainName);
        if (organizationEntity.isPresent()) {
            return OrganizationEntityToSubdomain.getInstance().apply(organizationEntity.get());
        }
        Optional<TutorEntity> tutorEntity = tutorRepository.findByAlias(subdomainName);
        if (tutorEntity.isPresent()) {
            return TutorEntityToSubdomain.getInstance().apply(tutorEntity.get());
        }
        throw new SubdomainNotFoundException();
    }

    @Override
    public boolean validateIfUserIsAllowedToLoginToSubdomain(Subdomain subdomain, LoginCredentialsEntity loginCredentialsEntity) {
        return false;
    }
}
