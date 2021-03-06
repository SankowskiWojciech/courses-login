package com.github.sankowskiwojciech.courseslogin.controller.subdomain;

import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.coursescorelib.service.subdomain.SubdomainService;
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
    @GetMapping("/subdomain/{subdomainAlias}")
    public Subdomain readSubdomainInformation(@PathVariable("subdomainAlias") String subdomainAlias) {
        return subdomainService.readSubdomainInformation(subdomainAlias);
    }
}
