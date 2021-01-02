package com.github.sankowskiwojciech.courseslogin.controller.login.validator;

import com.github.sankowskiwojciech.coursescorelib.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.coursescorelib.model.login.LoginCredentials;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginCredentialsValidator {

    public static void validateLoginCredentials(LoginCredentials loginCredentials) {
        if (loginCredentials == null
                || loginCredentials.getUserEmailAddress() == null
                || loginCredentials.getPassword() == null
                || loginCredentials.getUserEmailAddress().isBlank()
                || loginCredentials.getPassword().isBlank()
        ) {
            throw new InvalidCredentialsException();
        }
    }
}