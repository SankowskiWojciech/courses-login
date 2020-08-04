package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.courseslogin.backend.repository.LoginCredentialsRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.courseslogin.model.login.LoginCredentials;
import com.github.sankowskiwojciech.courseslogin.model.token.Token;
import com.github.sankowskiwojciech.courseslogin.service.password.PasswordService;
import com.github.sankowskiwojciech.courseslogin.service.subdomain.SubdomainService;
import com.github.sankowskiwojciech.courseslogin.service.token.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginCredentialsRepository loginCredentialsRepository;
    private final PasswordService passwordService;
    private final TokenService tokenService;
    private final SubdomainService subdomainService;

    @Override
    public Token loginUserToSubdomain(String subdomainEmailAddress, LoginCredentials loginCredentialsFromRequest) {
        LoginCredentialsEntity loginCredentialsEntity = readLoginCredentials(loginCredentialsFromRequest.getEmailAddress());
        subdomainService.validateIfUserIsAllowedToLoginToSubdomain(subdomainEmailAddress, loginCredentialsEntity.getEmailAddress());
        passwordService.validatePassword(loginCredentialsFromRequest.getPassword(), loginCredentialsEntity.getEncryptedPassword());
        return tokenService.generateJwsToken(loginCredentialsEntity.getEmailAddress());
    }

    private LoginCredentialsEntity readLoginCredentials(String emailAddress) {
        return loginCredentialsRepository.findByEmailAddress(emailAddress)
                .orElseThrow(InvalidCredentialsException::new);
    }
}
