package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.account.AccountType;
import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ENCRYPTED_PASSWORD_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginCredentialsEntityStub {

    public static LoginCredentialsEntity create() {
        return new LoginCredentialsEntity(EMAIL_ADDRESS_STUB, ENCRYPTED_PASSWORD_STUB, AccountType.TUTOR);
    }
}
