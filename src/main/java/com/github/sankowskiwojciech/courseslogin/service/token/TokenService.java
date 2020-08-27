package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.TokenResponse;

public interface TokenService {

    TokenResponse generateToken(LoginCredentialsEntity loginCredentialsEntity);
}
