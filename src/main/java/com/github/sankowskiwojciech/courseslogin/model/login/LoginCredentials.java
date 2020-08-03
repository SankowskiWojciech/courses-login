package com.github.sankowskiwojciech.courseslogin.model.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginCredentials {
    private String emailAddress;
    private String password;
}
