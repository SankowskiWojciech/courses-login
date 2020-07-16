package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.db.user.UserCredentialsEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCredentialsEntityStub {

    public static UserCredentialsEntity createWithAddressEmailAndPassword(String emailAddress, String password) {
        return new UserCredentialsEntity(emailAddress, password);
    }
}
