package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCredentialsStub {

    public static UserCredentials createWithAddressEmailAndPassword(String emailAddress, String password) {
        return new UserCredentials(emailAddress, password);
    }

    public static UserCredentials create() {
        return new UserCredentials(EMAIL_ADDRESS_STUB, PASSWORD_STUB);
    }

    public static UserCredentials createEmpty() {
        return new UserCredentials(null, null);
    }
}
