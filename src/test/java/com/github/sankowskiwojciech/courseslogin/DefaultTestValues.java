package com.github.sankowskiwojciech.courseslogin;

import java.util.Base64;

public final class DefaultTestValues {
    //organization
    public static final String ORGANIZATION_ALIAS_STUB = "ssit";

    public static final String EMAIL_ADDRESS_STUB = "sankowski.wojciech@gmail.com";
    public static final String PASSWORD_STUB = "VGVzdDE=";
    public static final String PASSWORD_HASH_STUB = "$2a$15$IuZTBhr5cSi9f4uaZ52uOekG.S/CvFRtxNhQGh1yjhHwJrOY0GbkW";
    public static final String INVALID_PASSWORD_STUB = Base64.getEncoder().encodeToString("INVALID_PASSWORD_STUB".getBytes());
    public static final String TOKEN_VALUE_STUB = "tokenValueStub";
    public static final String RSA_PUBLIC_KEY_STUB = "rsaPublicKey";
    public static final byte[] RSA_PUBLIC_KEY_BYTE_ARRAY_STUB = "rsaPublicKey".getBytes();
    public static final String TOKEN_STUB = "jwsTokenStub";
}
