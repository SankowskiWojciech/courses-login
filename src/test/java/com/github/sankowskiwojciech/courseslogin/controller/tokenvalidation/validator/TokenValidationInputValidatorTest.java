package com.github.sankowskiwojciech.courseslogin.controller.tokenvalidation.validator;

import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidRequestBody;
import com.github.sankowskiwojciech.courseslogin.model.tokenvalidation.TokenValidationInput;
import com.github.sankowskiwojciech.courseslogin.stub.TokenValidationInputStub;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TokenValidationInputValidatorTest {

    @Test(expected = InvalidRequestBody.class)
    public void shouldThrowInvalidRequestBodyWhenTokenValidationInputIsNull() {
        //given
        TokenValidationInput tokenValidationInputStub = null;

        //when
        TokenValidationInputValidator.validateTokenValidationInput(tokenValidationInputStub);

        //then exception is thrown
    }

    @Test(expected = InvalidRequestBody.class)
    public void shouldThrowInvalidRequestBodyWhenTokenValidationInputIsMissingUserEmailAddress() {
        //given
        TokenValidationInput tokenValidationInputStub = TokenValidationInputStub.createWithUserEmailAddress(null);

        //when
        TokenValidationInputValidator.validateTokenValidationInput(tokenValidationInputStub);

        //then exception is thrown
    }

    @Test(expected = InvalidRequestBody.class)
    public void shouldThrowInvalidRequestBodyWhenTokenValidationInputIsMissingTokenValue() {
        //given
        TokenValidationInput tokenValidationInputStub = TokenValidationInputStub.createWithTokenValue(StringUtils.EMPTY);

        //when
        TokenValidationInputValidator.validateTokenValidationInput(tokenValidationInputStub);

        //then exception is thrown
    }

    @Test
    public void shouldDoNothingWhenTokenValidationInputIsValid() {
        //given
        TokenValidationInput tokenValidationInputStub = TokenValidationInputStub.create();

        //when
        TokenValidationInputValidator.validateTokenValidationInput(tokenValidationInputStub);

        //then nothing happens
    }
}