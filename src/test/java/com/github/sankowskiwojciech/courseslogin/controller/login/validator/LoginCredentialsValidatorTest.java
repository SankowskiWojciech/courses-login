package com.github.sankowskiwojciech.courseslogin.controller.login.validator;

import com.github.sankowskiwojciech.coursescorelib.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.coursescorelib.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.stub.LoginCredentialsStub;
import org.junit.Test;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_STUB;

public class LoginCredentialsValidatorTest {

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenUserCredentialsIsNull() {
        //given
        LoginCredentials loginCredentialsStub = LoginCredentialsStub.createEmpty();

        //when
        LoginCredentialsValidator.validateLoginCredentials(loginCredentialsStub);

        //then exception is thrown
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenEmailAddressIsNull() {
        //given
        LoginCredentials loginCredentialsStub = LoginCredentialsStub.createWithAddressEmailAndPassword(null, PASSWORD_STUB);

        //when
        LoginCredentialsValidator.validateLoginCredentials(loginCredentialsStub);

        //then exception is thrown
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenPasswordIsNull() {
        //given
        LoginCredentials loginCredentialsStub = LoginCredentialsStub.createWithAddressEmailAndPassword(EMAIL_ADDRESS_STUB, null);

        //when
        LoginCredentialsValidator.validateLoginCredentials(loginCredentialsStub);

        //then exception is thrown
    }

    @Test
    public void shouldDoNothingWhenValidUserCredentialsAreProvided() {
        //given
        LoginCredentials loginCredentialsStub = LoginCredentialsStub.createWithAddressEmailAndPassword(EMAIL_ADDRESS_STUB, PASSWORD_STUB);

        //when
        LoginCredentialsValidator.validateLoginCredentials(loginCredentialsStub);

        //then nothing happens
    }
}