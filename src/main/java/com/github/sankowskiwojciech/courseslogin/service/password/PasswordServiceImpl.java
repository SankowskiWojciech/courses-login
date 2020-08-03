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
    public String encodePassword(String plainPassword) {
        String encodedPassword = passwordEncoder.encode(plainPassword);
        return new String(Base64.getEncoder().encode(encodedPassword.getBytes()));
    }

    @Override
    public void validatePassword(String passwordFromRequest, String encodedPassword) {
        if (!isPasswordValid(passwordFromRequest, encodedPassword)) {
            throw new InvalidCredentialsException();
        }
    }

    private boolean isPasswordValid(String plainPassword, String encryptedPassword) {
        return passwordEncoder.matches(plainPassword, new String(Base64.getDecoder().decode(encryptedPassword.getBytes())));
    }
}
