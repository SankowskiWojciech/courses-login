package com.github.sankowskiwojciech.courseslogin.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserCredentials {
    private String emailAddress;
    private String password;
}
