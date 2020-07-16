package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCredentialsStub {

    public static UserCredentials createWithAddressEmailAndPassword(String emailAddress, String password) {
        return new UserCredentials(emailAddress, password);
    }

    public static UserCredentials createEmpty() {
        return new UserCredentials(null, null);
    }
}
