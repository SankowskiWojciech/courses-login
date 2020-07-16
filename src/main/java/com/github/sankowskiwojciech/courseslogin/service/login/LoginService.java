package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;

public interface LoginService {

    Token loginUser(UserCredentials userCredentials);
}
