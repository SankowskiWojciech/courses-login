package com.github.sankowskiwojciech.courseslogin;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.KeyPair;
import java.util.Date;

public class JWTTest {

    //    @Test()
    public void should() {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.ES512);

        JwtBuilder jwtBuilder = Jwts.builder().setExpiration(new Date());
        jwtBuilder.signWith(keyPair.getPublic());
        jwtBuilder.compact();
    }
}
