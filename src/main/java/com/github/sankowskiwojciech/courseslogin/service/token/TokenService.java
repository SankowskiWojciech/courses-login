package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.coursescorelib.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenResponse;

public interface TokenService {

    TokenResponse generateToken(LoginCredentialsEntity loginCredentialsEntity);
}
