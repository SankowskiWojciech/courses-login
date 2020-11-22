package com.github.sankowskiwojciech.courseslogin.controller.login;

import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenResponse;
import com.github.sankowskiwojciech.coursescorelib.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.controller.login.validator.LoginCredentialsValidator;
import com.github.sankowskiwojciech.courseslogin.service.login.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/subdomain/{subdomainAlias}/login")
    public TokenResponse loginUserToSubdomain(@PathVariable("subdomainAlias") String subdomainAlias, @RequestBody LoginCredentials loginCredentials) {
        LoginCredentialsValidator.validateLoginCredentials(loginCredentials);
        return loginService.loginUserToSubdomain(subdomainAlias, loginCredentials);
    }
}
