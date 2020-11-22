package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.SubdomainType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubdomainEntityStub {
    public static SubdomainEntity create(String subdomainId, SubdomainType subdomainType, Set<SubdomainUserAccessEntity> subdomainUserAccessEntities) {
        return new SubdomainEntity(subdomainId, subdomainType, subdomainUserAccessEntities);
    }
}
