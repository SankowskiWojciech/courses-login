package com.github.sankowskiwojciech.courseslogin.model.subdomain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Subdomain {
    private String name;
    private String alias;
    private String description;
    private String emailAddress;
    private String phoneNumber;
    private String websiteUrl;
}
