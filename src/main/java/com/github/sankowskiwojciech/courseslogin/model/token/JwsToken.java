package com.github.sankowskiwojciech.courseslogin.model.token;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class JwsToken {
    private final String token;
}
