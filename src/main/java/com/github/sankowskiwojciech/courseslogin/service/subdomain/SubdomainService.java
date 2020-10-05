package com.github.sankowskiwojciech.courseslogin.service.subdomain;

import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;

public interface SubdomainService {

    Subdomain readSubdomainInformationIfSubdomainExists(String subdomainName);

    void validateIfUserIsAllowedToLoginToSubdomain(String subdomainEmailAddress, String userEmailAddress);
}
