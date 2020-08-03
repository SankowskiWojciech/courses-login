package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.db.tutor.TutorEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TUTOR_ALIAS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TUTOR_DESCRIPTION_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TUTOR_FIRST_NAME_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TUTOR_ID_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TUTOR_LAST_NAME_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.TUTOR_PHONE_NUMBER_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TutorEntityStub {

    public static TutorEntity create() {
        return TutorEntity.builder()
                .tutorId(TUTOR_ID_STUB)
                .alias(TUTOR_ALIAS_STUB)
                .firstName(TUTOR_FIRST_NAME_STUB)
                .lastName(TUTOR_LAST_NAME_STUB)
                .description(TUTOR_DESCRIPTION_STUB)
                .emailAddress(TUTOR_EMAIL_ADDRESS_STUB)
                .phoneNumber(TUTOR_PHONE_NUMBER_STUB)
                .build();
    }
}
