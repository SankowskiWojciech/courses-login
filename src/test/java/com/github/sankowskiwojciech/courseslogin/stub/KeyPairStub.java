package com.github.sankowskiwojciech.courseslogin.stub;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.KeyPair;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KeyPairStub {
    public static KeyPair create() {
        return Keys.keyPairFor(SignatureAlgorithm.ES512);
    }
}
