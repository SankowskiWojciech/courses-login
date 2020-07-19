package com.github.sankowskiwojciech.courseslogin.service.token;

import com.github.sankowskiwojciech.courseslogin.model.token.JwsToken;

public interface TokenService {

    JwsToken generateJwsToken(String emailAddress);
}
