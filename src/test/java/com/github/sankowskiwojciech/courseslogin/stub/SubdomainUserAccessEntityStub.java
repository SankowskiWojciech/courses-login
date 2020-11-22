package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntityId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubdomainUserAccessEntityStub {
    public static SubdomainUserAccessEntity create(String subdomainAlias, String userEmailAddress) {
        return new SubdomainUserAccessEntity(new SubdomainUserAccessEntityId(subdomainAlias, userEmailAddress), null);
    }
}
