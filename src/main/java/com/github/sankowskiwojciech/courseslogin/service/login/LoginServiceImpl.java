package com.github.sankowskiwojciech.courseslogin.service.login;

import com.github.sankowskiwojciech.coursescorelib.backend.repository.LoginCredentialsRepository;
import com.github.sankowskiwojciech.coursescorelib.model.db.login.LoginCredentialsEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenResponse;
import com.github.sankowskiwojciech.coursescorelib.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.coursescorelib.model.login.LoginCredentials;
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
    public TokenResponse loginUserToSubdomain(String subdomainAlias, LoginCredentials loginCredentialsFromRequest) {
        LoginCredentialsEntity loginCredentialsEntity = readLoginCredentials(loginCredentialsFromRequest.getUserEmailAddress());
        subdomainService.validateIfUserIsAllowedToLoginToSubdomain(subdomainAlias, loginCredentialsEntity.getUserEmailAddress());
        passwordService.validatePassword(loginCredentialsFromRequest.getPassword(), loginCredentialsEntity.getPasswordHash());
        return tokenService.generateToken(loginCredentialsEntity);
    }

    private LoginCredentialsEntity readLoginCredentials(String emailAddress) {
        return loginCredentialsRepository.findById(emailAddress)
                .orElseThrow(InvalidCredentialsException::new);
    }
}
