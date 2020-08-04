package com.github.sankowskiwojciech.courseslogin.service.password;

public interface PasswordService {

    String createPasswordHash(String plainPassword);

    void validatePassword(String passwordFromRequest, String passwordHash);
}
