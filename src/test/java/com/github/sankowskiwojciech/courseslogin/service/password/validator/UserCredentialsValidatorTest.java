package com.github.sankowskiwojciech.courseslogin.service.password.validator;

import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import com.github.sankowskiwojciech.courseslogin.stub.UserCredentialsStub;
import org.junit.Test;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.PASSWORD_STUB;

public class UserCredentialsValidatorTest {

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenUserCredentialsIsNull() {
        //given
        UserCredentials userCredentialsStub = UserCredentialsStub.createEmpty();

        //when
        UserCredentialsValidator.validateUserCredentials(userCredentialsStub);

        //then exception is thrown
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenEmailAddressIsNull() {
        //given
        UserCredentials userCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(null, PASSWORD_STUB);

        //when
        UserCredentialsValidator.validateUserCredentials(userCredentialsStub);

        //then exception is thrown
    }

    @Test(expected = InvalidCredentialsException.class)
    public void shouldThrowInvalidCredentialsExceptionWhenPasswordIsNull() {
        //given
        UserCredentials userCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(EMAIL_ADDRESS_STUB, null);

        //when
        UserCredentialsValidator.validateUserCredentials(userCredentialsStub);

        //then exception is thrown
    }

    @Test
    public void shouldDoNothingWhenValidUserCredentialsAreProvided() {
        //given
        UserCredentials userCredentialsStub = UserCredentialsStub.createWithAddressEmailAndPassword(EMAIL_ADDRESS_STUB, PASSWORD_STUB);

        //when
        UserCredentialsValidator.validateUserCredentials(userCredentialsStub);

        //then nothing happens
    }
}