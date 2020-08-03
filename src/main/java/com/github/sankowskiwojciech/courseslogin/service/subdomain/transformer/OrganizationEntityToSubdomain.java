package com.github.sankowskiwojciech.courseslogin.service.subdomain.transformer;

import com.github.sankowskiwojciech.courseslogin.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.SubdomainType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrganizationEntityToSubdomain implements Function<OrganizationEntity, Subdomain> {

    private static final OrganizationEntityToSubdomain INSTANCE = new OrganizationEntityToSubdomain();

    @Override
    public Subdomain apply(OrganizationEntity organizationEntity) {
        return new Subdomain(organizationEntity.getOrganizationId(), SubdomainType.ORGANIZATION);
    }

    public static OrganizationEntityToSubdomain getInstance() {
        return INSTANCE;
    }
}
