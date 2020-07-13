package com.github.sankowskiwojciech.courseslogin.registration;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;

@AllArgsConstructor
public class PasswordEncoderService {

    private final PasswordEncoder passwordEncoder;

    public String encodePassword(String plainPassword) {
        String encodedPassword = passwordEncoder.encode(plainPassword);
        return new String(Base64.getEncoder().encode(encodedPassword.getBytes()));
    }

    public boolean validatePassword(String plainPassword, String encodedPassword) {
        return passwordEncoder.matches(plainPassword, new String(Base64.getDecoder().decode(encodedPassword.getBytes())));
    }
}
