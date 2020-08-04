package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.token.Token;

public interface TokenService {

    Token generateToken(LoginCredentialsEntity loginCredentialsEntity);
}
