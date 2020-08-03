package com.github.sankowskiwojciech.courseslogin.controller.login;

import com.github.sankowskiwojciech.courseslogin.controller.login.validator.LoginCredentialsValidator;
import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.model.token.JwsToken;
import com.github.sankowskiwojciech.courseslogin.service.login.LoginService;
import com.github.sankowskiwojciech.courseslogin.service.subdomain.SubdomainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private final SubdomainService subdomainService;
    private final LoginService loginService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{subdomainName}/login")
    public JwsToken login(@PathVariable("subdomainName") String subdomainName, @RequestBody LoginCredentials loginCredentials) {
        LoginCredentialsValidator.validateLoginCredentials(loginCredentials);
        String subdomainEmailAddress = subdomainService.readSubdomainEmailAddressIfSubdomainExists(subdomainName);
        return loginService.loginUserToSubdomain(subdomainEmailAddress, loginCredentials);
    }
}
