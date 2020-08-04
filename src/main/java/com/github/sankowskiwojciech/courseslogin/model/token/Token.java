package com.github.sankowskiwojciech.courseslogin.model.token;

import com.github.sankowskiwojciech.courseslogin.model.account.AccountType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Token {
    private final String tokenValue;
    private final AccountType accountType;
}
