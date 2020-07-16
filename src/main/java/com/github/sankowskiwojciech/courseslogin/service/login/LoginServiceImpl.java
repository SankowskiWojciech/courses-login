package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import com.github.sankowskiwojciech.courseslogin.service.password.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final PasswordService passwordService;

    @Override
    public Token loginUser(UserCredentials userCredentials) {
        passwordService.validatePassword(userCredentials);
        return new Token(UUID.randomUUID().toString());
    }
}
