package com.github.sankowskiwojciech.courseslogin;

import java.util.Base64;

public interface DefaultTestValues {

    //organization
    String ORGANIZATION_ALIAS_STUB = "ssit";
    String ORGANIZATION_NAME_STUB = "Szkoła śpiewu i tańca";
    String ORGANIZATION_DESCRIPTION_STUB = "Szkoła gdzie się uczy śpiewać i tańczyć";
    String ORGANIZATION_EMAIL_ADDRESS_STUB = "not.spam@dancewithme.pl";
    String ORGANIZATION_PHONE_NUMBER_STUB = "123456789";
    String ORGANIZATION_WEBSITE_URL_STUB = "http://dancewithme.pl";

    //tutor
    String TUTOR_ALIAS_STUB = "wsankowski";
    String TUTOR_FIRST_NAME_STUB = "Wojciech";
    String TUTOR_LAST_NAME_STUB = "Sankowski";
    String TUTOR_DESCRIPTION_STUB = "Java Developer";
    String TUTOR_EMAIL_ADDRESS_STUB = "sankowski.wojciech@gmail.com";
    String TUTOR_PHONE_NUMBER_STUB = "111222333";

    String EMAIL_ADDRESS_STUB = "sankowski.wojciech@gmail.com";
    String PASSWORD_STUB = "VGVzdDE=";
    String PASSWORD_HASH_STUB = "$2a$15$IuZTBhr5cSi9f4uaZ52uOekG.S/CvFRtxNhQGh1yjhHwJrOY0GbkW";
    String INVALID_PASSWORD_STUB = Base64.getEncoder().encodeToString("INVALID_PASSWORD_STUB".getBytes());
    String TOKEN_VALUE_STUB = "tokenValueStub";
    String RSA_PUBLIC_KEY_STUB = "rsaPublicKey";
    byte[] RSA_PUBLIC_KEY_BYTE_ARRAY_STUB = "rsaPublicKey".getBytes();
    String TOKEN_STUB = "jwsTokenStub";
}
