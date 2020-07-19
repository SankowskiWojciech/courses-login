package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.model.token.JwsToken;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;

public interface LoginService {

    JwsToken loginUser(UserCredentials userCredentials);
}
