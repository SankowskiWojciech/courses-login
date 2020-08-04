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

    //student
    String STUDENT_EMAIL_ADDRESS_STUB = "marcin.b@gmail.com";

    //parent
    String PARENT_EMAIL_ADDRESS_STUB = "kbac@gmail.com";

    String EMAIL_ADDRESS_STUB = "sankowski.wojciech@gmail.com";
    String PASSWORD_STUB = "Test1";
    String ENCRYPTED_PASSWORD_STUB = "JDJhJDE1JFhNV2RBYWxFREhQc3BKVk93cHRVdnVsN3QyRWMyLlVSZTNDMmJqR0MwNGkuNzdFTU9zVExD";
    String INVALID_PASSWORD_STUB = Base64.getEncoder().encodeToString("INVALID_PASSWORD_STUB".getBytes());
    String TOKEN_VALUE_STUB = "tokenValue";
    String RSA_PUBLIC_KEY_STUB = "rsaPublicKey";
    byte[] RSA_PUBLIC_KEY_BYTE_ARRAY_STUB = "rsaPublicKey".getBytes();
    String TOKEN_STUB = "jwsTokenStub";
}
