package com.github.sankowskiwojciech.courseslogin.controller.login.validator;

import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginCredentialsValidator {

    public static void validateLoginCredentials(LoginCredentials loginCredentials) {
        if (loginCredentials == null || StringUtils.isBlank(loginCredentials.getEmailAddress()) || StringUtils.isBlank(loginCredentials.getPassword())) {
            throw new InvalidCredentialsException();
        }
    }
}