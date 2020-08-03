package com.github.sankowskiwojciech.courseslogin.stub;

import com.github.sankowskiwojciech.courseslogin.model.db.organization.OrganizationEntity;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_ALIAS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_DESCRIPTION_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_ID_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_NAME_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_PHONE_NUMBER_STUB;
import static com.github.sankowskiwojciech.courseslogin.DefaultTestValues.ORGANIZATION_WEBSITE_URL_STUB;

@NoArgsConstructor
public class OrganizationEntityStub {

    public static OrganizationEntity create() {
        return OrganizationEntity.builder()
                .organizationId(ORGANIZATION_ID_STUB)
                .alias(ORGANIZATION_ALIAS_STUB)
                .name(ORGANIZATION_NAME_STUB)
                .description(ORGANIZATION_DESCRIPTION_STUB)
                .emailAddress(ORGANIZATION_EMAIL_ADDRESS_STUB)
                .phoneNumber(ORGANIZATION_PHONE_NUMBER_STUB)
                .websiteUrl(ORGANIZATION_WEBSITE_URL_STUB)
                .build();
    }
}
