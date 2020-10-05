package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.coursescorelib.model.account.AccountType;
import com.github.sankowskiwojciech.coursescorelib.model.db.login.LoginCredentialsEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_HASH_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginCredentialsEntityStub {

    public static LoginCredentialsEntity create() {
        return new LoginCredentialsEntity(EMAIL_ADDRESS_STUB, PASSWORD_HASH_STUB, AccountType.TUTOR);
    }
}
