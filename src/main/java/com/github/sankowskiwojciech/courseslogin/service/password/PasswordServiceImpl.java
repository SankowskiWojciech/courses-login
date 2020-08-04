package com.github.sankowskiwojciech.courseslogin.service.password;

import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@AllArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String createPasswordHash(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    @Override
    public void validatePassword(String passwordFromRequest, String passwordHash) {
        if (!isPasswordValid(passwordFromRequest, passwordHash)) {
            throw new InvalidCredentialsException();
        }
    }

    private boolean isPasswordValid(String passwordFromRequest, String passwordHash) {
        return passwordEncoder.matches(new String(Base64.getDecoder().decode(passwordFromRequest.getBytes())), passwordHash);
    }
}
