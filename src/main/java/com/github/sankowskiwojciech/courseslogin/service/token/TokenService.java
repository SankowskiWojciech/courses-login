package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.model.token.Token;

public interface TokenService {

    Token generateJwsToken(String emailAddress);
}
