package com.github.sankowskiwojciech.courseslogin.controller.subdomain;

import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.courseslogin.service.subdomain.SubdomainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SubdomainController {

    private final SubdomainService subdomainService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/subdomain/{subdomainName}")
    public Subdomain readSubdomainInformation(@PathVariable("subdomainName") String subdomainName) {
        return subdomainService.readSubdomainInformationIfSubdomainExists(subdomainName);
    }
}
