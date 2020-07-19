package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.model.token.JwsToken;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import com.github.sankowskiwojciech.courseslogin.service.password.PasswordService;
import com.github.sankowskiwojciech.courseslogin.service.token.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final PasswordService passwordService;
    private final TokenService tokenService;

    @Override
    public JwsToken loginUser(UserCredentials userCredentials) {
        passwordService.validatePassword(userCredentials);
        return tokenService.generateJwsToken(userCredentials.getEmailAddress());
    }
}
