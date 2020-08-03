package com.github.sankowskiwojciech.courseslogin.controller.login.validator;

import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.service.password.validator.UserCredentialsValidator;
import com.github.sankowskiwojciech.courseslogin.stub.UserCredentialsStub;
import org.junit.Test;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_STUB;

public class LoginCredentialsValidatorTest {

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenUserCredentialsIsNull() {
        //given
        LoginCredentials loginCredentialsStub = UserCredentialsStub.createEmpty();

        //when
        com.github.sankowskiwojciech.courseslogin.service.password.validator.UserCredentialsValidator.validateUserCredentials(loginCredentialsStub);

        //then exception is thrown
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenEmailAddressIsNull() {
        //given
        LoginCredentials loginCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(null, PASSWORD_STUB);

        //when
        com.github.sankowskiwojciech.courseslogin.service.password.validator.UserCredentialsValidator.validateUserCredentials(loginCredentialsStub);

        //then exception is thrown
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenPasswordIsNull() {
        //given
        LoginCredentials loginCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(EMAIL_ADDRESS_STUB, null);

        //when
        com.github.sankowskiwojciech.courseslogin.service.password.validator.UserCredentialsValidator.validateUserCredentials(loginCredentialsStub);

        //then exception is thrown
    }

    @Test
    public void shouldDoNothingWhenValidUserCredentialsAreProvided() {
        //given
        LoginCredentials loginCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(EMAIL_ADDRESS_STUB, PASSWORD_STUB);

        //when
        UserCredentialsValidator.validateUserCredentials(loginCredentialsStub);

        //then nothing happens
    }
}