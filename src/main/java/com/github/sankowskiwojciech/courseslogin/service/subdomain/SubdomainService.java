package com.github.sankowskiwojciech.courseslogin.service.subdomain;

import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.subdomain.Subdomain;

public interface SubdomainService {

    Subdomain readSubdomainIfExists(String subdomainName);

    boolean validateIfUserIsAllowedToLoginToSubdomain(Subdomain subdomain, LoginCredentialsEntity loginCredentialsEntity);
}
