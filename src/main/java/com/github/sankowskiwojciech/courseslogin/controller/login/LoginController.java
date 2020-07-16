package com.github.sankowskiwojciech.courseslogin.controller.login;

import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import com.github.sankowskiwojciech.courseslogin.service.login.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Token login(@RequestBody UserCredentials userCredentials) {
        return loginService.loginUser(userCredentials);
    }
}
