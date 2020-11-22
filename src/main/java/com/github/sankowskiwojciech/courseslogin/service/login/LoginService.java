package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenResponse;
import com.github.sankowskiwojciech.coursescorelib.model.login.LoginCredentials;

public interface LoginService {

    TokenResponse loginUserToSubdomain(String subdomainAlias, LoginCredentials loginCredentialsFromRequest);
}
