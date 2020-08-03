package com.github.sankowskiwojciech.courseslogin.service.subdomain;

public interface SubdomainService {

    String readSubdomainEmailAddressIfSubdomainExists(String subdomainName);

    void validateIfUserIsAllowedToLoginToSubdomain(String subdomainEmailAddress, String userEmailAddress);
}
