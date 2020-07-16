package com.github.sankowskiwojciech.courseslogin.service.password;

import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;

public interface PasswordService {

    String encodePassword(String plainPassword);

    void validatePassword(UserCredentials userCredentials);
}
