package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.model.token.TokenResponse;

public interface LoginService {

    TokenResponse loginUserToSubdomain(String subdomainEmailAddress, LoginCredentials loginCredentialsFromRequest);
}
