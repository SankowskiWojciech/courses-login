package com.github.sankowskiwojciech.courseslogin.service.subdomain;

import com.github.sankowskiwojciech.coursescorelib.backend.repository.OrganizationRepository;
import com.github.sankowskiwojciech.coursescorelib.backend.repository.SubdomainRepository;
import com.github.sankowskiwojciech.coursescorelib.backend.repository.TutorRepository;
import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.exception.SubdomainNotFoundException;
import com.github.sankowskiwojciech.coursescorelib.model.exception.permission.UserNotAllowedToAccessSubdomainException;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.SubdomainType;
import com.github.sankowskiwojciech.courseslogin.service.subdomain.transformer.OrganizationEntityToSubdomain;
import com.github.sankowskiwojciech.courseslogin.service.subdomain.transformer.TutorEntityToSubdomain;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SubdomainServiceImpl implements SubdomainService {

    private final OrganizationRepository organizationRepository;
    private final TutorRepository tutorRepository;
    private final SubdomainRepository subdomainRepository;

    @Override
    public Subdomain readSubdomainInformation(String subdomainAlias) {
        SubdomainEntity subdomainEntity = readSubdomainEntity(subdomainAlias);
        if (SubdomainType.ORGANIZATION.equals(subdomainEntity.getSubdomainType())) {
            Optional<OrganizationEntity> organizationEntityOptional = organizationRepository.findByAlias(subdomainAlias);
            return OrganizationEntityToSubdomain.getInstance().apply(organizationEntityOptional.get());
        } else {
            Optional<TutorEntity> tutorEntityOptional = tutorRepository.findByAlias(subdomainAlias);
            return TutorEntityToSubdomain.getInstance().apply(tutorEntityOptional.get());
        }
    }

    @Override
    public void validateIfUserIsAllowedToLoginToSubdomain(String subdomainAlias, String userEmailAddress) {
        SubdomainEntity subdomainEntity = readSubdomainEntity(subdomainAlias);
        Set<SubdomainUserAccessEntity> subdomainUserAccessEntities = subdomainEntity.getSubdomainUserAccessEntities();
        if (subdomainUserAccessEntities.stream().noneMatch(subdomainUserAccessEntity -> userEmailAddress.equals(subdomainUserAccessEntity.getSubdomainUserAccessEntityId().getUserEmailAddress()))) {
            throw new UserNotAllowedToAccessSubdomainException();
        }
    }

    private SubdomainEntity readSubdomainEntity(String subdomainAlias) {
        if (StringUtils.isBlank(subdomainAlias)) {
            throw new SubdomainNotFoundException();
        }
        return subdomainRepository.findById(subdomainAlias).orElseThrow(SubdomainNotFoundException::new);
    }
}
