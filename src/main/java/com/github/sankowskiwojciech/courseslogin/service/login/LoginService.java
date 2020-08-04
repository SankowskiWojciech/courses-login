package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.model.token.Token;

public interface LoginService {

    Token loginUserToSubdomain(String subdomainEmailAddress, LoginCredentials loginCredentialsFromRequest);
}
