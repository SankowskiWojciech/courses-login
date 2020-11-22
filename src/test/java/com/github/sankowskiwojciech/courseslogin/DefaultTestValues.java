package com.github.sankowskiwojciech.courseslogin;

import java.util.Base64;

public interface DefaultTestValues {

    //organization
    String ORGANIZATION_ALIAS_STUB = "ssit";

    String EMAIL_ADDRESS_STUB = "sankowski.wojciech@gmail.com";
    String PASSWORD_STUB = "VGVzdDE=";
    String PASSWORD_HASH_STUB = "$2a$15$IuZTBhr5cSi9f4uaZ52uOekG.S/CvFRtxNhQGh1yjhHwJrOY0GbkW";
    String INVALID_PASSWORD_STUB = Base64.getEncoder().encodeToString("INVALID_PASSWORD_STUB".getBytes());
    String TOKEN_VALUE_STUB = "tokenValueStub";
    String RSA_PUBLIC_KEY_STUB = "rsaPublicKey";
    byte[] RSA_PUBLIC_KEY_BYTE_ARRAY_STUB = "rsaPublicKey".getBytes();
    String TOKEN_STUB = "jwsTokenStub";
}
