package com.github.sankowskiwojciech.courseslogin.service.password.validator;

import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCredentialsValidator {

    public static void validateUserCredentials(UserCredentials userCredentials) {
        if (userCredentials == null || StringUtils.isBlank(userCredentials.getEmailAddress()) || StringUtils.isBlank(userCredentials.getPassword())) {
            throw new InvalidCredentialsException();
        }
    }
}
