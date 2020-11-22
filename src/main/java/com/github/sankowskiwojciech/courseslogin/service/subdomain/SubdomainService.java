package com.github.sankowskiwojciech.courseslogin.service.subdomain;

import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;

public interface SubdomainService {

    Subdomain readSubdomainInformation(String subdomainAlias);

    void validateIfUserIsAllowedToLoginToSubdomain(String subdomainAlias, String userEmailAddress);
}
