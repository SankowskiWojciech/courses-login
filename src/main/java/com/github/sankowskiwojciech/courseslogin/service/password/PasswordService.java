package com.github.sankowskiwojciech.courseslogin.service.password;

public interface PasswordService {

    String encodePassword(String plainPassword);

    void validatePassword(String passwordFromRequest, String encodedPassword);
}
