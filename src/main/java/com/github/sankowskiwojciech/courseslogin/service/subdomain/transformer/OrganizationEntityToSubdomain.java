package com.github.sankowskiwojciech.courseslogin.service.subdomain.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.Subdomain;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrganizationEntityToSubdomain implements Function<OrganizationEntity, Subdomain> {

    private final static OrganizationEntityToSubdomain INSTANCE = new OrganizationEntityToSubdomain();

    @Override
    public Subdomain apply(OrganizationEntity organizationEntity) {
        return Subdomain.builder()
                .name(organizationEntity.getName())
                .alias(organizationEntity.getAlias())
                .description(organizationEntity.getDescription())
                .emailAddress(organizationEntity.getEmailAddress())
                .phoneNumber(organizationEntity.getPhoneNumber())
                .websiteUrl(organizationEntity.getWebsiteUrl())
                .build();
    }

    public static OrganizationEntityToSubdomain getInstance() {
        return INSTANCE;
    }
}
