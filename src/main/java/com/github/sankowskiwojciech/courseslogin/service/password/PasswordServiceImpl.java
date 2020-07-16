package com.github.sankowskiwojciech.courseslogin.service.password;

import com.github.sankowskiwojciech.courseslogin.backend.repository.UserCredentialsRepository;
import com.github.sankowskiwojciech.courseslogin.model.db.user.UserCredentialsEntity;
import com.github.sankowskiwojciech.courseslogin.model.exception.InvalidCredentialsException;
import com.github.sankowskiwojciech.courseslogin.model.user.UserCredentials;
import com.github.sankowskiwojciech.courseslogin.service.password.validator.UserCredentialsValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@AllArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private final PasswordEncoder passwordEncoder;
    private final UserCredentialsRepository userCredentialsRepository;

    @Override
    public String encodePassword(String plainPassword) {
        String encodedPassword = passwordEncoder.encode(plainPassword);
        return new String(Base64.getEncoder().encode(encodedPassword.getBytes()));
    }

    @Override
    public void validatePassword(UserCredentials userCredentials) {
        UserCredentialsValidator.validateUserCredentials(userCredentials);
        UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findById(userCredentials.getEmailAddress()).orElseThrow(InvalidCredentialsException::new);
        if (!isPasswordValid(userCredentials.getPassword(), userCredentialsEntity.getEncryptedPassword())) {
            throw new InvalidCredentialsException();
        }
    }

    private boolean isPasswordValid(String plainPassword, String encryptedPassword) {
        return passwordEncoder.matches(plainPassword, new String(Base64.getDecoder().decode(encryptedPassword.getBytes())));
    }
}
