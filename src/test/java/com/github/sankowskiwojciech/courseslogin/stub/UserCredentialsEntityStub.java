package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCredentialsEntityStub {

    public static LoginCredentialsEntity createWithAddressEmailAndPassword(String emailAddress, String password) {
        return new LoginCredentialsEntity(emailAddress, password, null);
    }
}
