package com.github.sankowskiwojciech.courseslogin.service;

import com.github.sankowskiwojciech.coursescorelib.backend.repository.OrganizationRepository;
import com.github.sankowskiwojciech.coursescorelib.backend.repository.SubdomainRepository;
import com.github.sankowskiwojciech.coursescorelib.backend.repository.TutorRepository;
import com.github.sankowskiwojciech.coursescorelib.service.subdomain.SubdomainService;
import com.github.sankowskiwojciech.coursescorelib.service.subdomain.SubdomainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServiceConfig {

    private static final int BCRYPT_PASSWORD_ENCODER_STRENGTH = 15;

    @Autowired
    private SubdomainRepository subdomainRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(BCRYPT_PASSWORD_ENCODER_STRENGTH);
    }

    @Bean
    public SubdomainService subdomainService() {
        return new SubdomainServiceImpl(organizationRepository, tutorRepository, subdomainRepository);
    }
}
