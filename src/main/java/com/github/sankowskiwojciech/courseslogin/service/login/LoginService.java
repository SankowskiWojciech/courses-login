package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.model.token.JwsToken;

public interface LoginService {

    JwsToken loginUserToSubdomain(String subdomainEmailAddress, LoginCredentials loginCredentialsFromRequest);
}
