package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCredentialsStub {

    public static LoginCredentials createWithAddressEmailAndPassword(String emailAddress, String password) {
        return new LoginCredentials(emailAddress, password);
    }

    public static LoginCredentials create() {
        return new LoginCredentials(EMAIL_ADDRESS_STUB, PASSWORD_STUB);
    }

    public static LoginCredentials createEmpty() {
        return new LoginCredentials(null, null);
    }
}
