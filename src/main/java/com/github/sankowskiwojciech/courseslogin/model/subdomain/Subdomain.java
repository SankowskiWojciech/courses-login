package com.github.sankowskiwojciech.courseslogin.model.subdomain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Subdomain {
    private long subdomainId;
    private SubdomainType subdomainType;
}
